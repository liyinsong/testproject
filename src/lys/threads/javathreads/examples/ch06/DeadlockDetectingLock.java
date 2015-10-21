package lys.threads.javathreads.examples.ch06;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDetectingLock extends ReentrantLock {

	private static List deadlockLocksRegistry = new ArrayList();

	private static synchronized void registerLock(DeadlockDetectingLock ddl) {
		if (!deadlockLocksRegistry.contains(ddl))
			deadlockLocksRegistry.add(ddl);
	}

	private static synchronized void unregisterLock(DeadlockDetectingLock ddl) {
		if (deadlockLocksRegistry.contains(ddl))
			deadlockLocksRegistry.remove(ddl);
	}

	private List hardwaitingThreads = new ArrayList();

	private static synchronized void markAsHardwait(List l, Thread t) {
		if (!l.contains(t))
			l.add(t);
	}

	private static synchronized void freeIfHardwait(List l, Thread t) {
		if (l.contains(t))
			l.remove(t);
	}

	private static Iterator getAllLocksOwned(Thread t) {
		DeadlockDetectingLock current;
		ArrayList results = new ArrayList();
		Iterator itr = deadlockLocksRegistry.iterator();
		while (itr.hasNext()) {
			current = (DeadlockDetectingLock) itr.next();
			if (current.getOwner() == t)
				results.add(current);
		}
		return results.iterator();
	}

	private static Iterator getAllThreadsHardwaiting(DeadlockDetectingLock l) {
		return l.hardwaitingThreads.iterator();
	}

	private static synchronized boolean canThreadWaitOnLock(Thread t,
			DeadlockDetectingLock l) {
		Iterator locksOwned = getAllLocksOwned(t);
		while (locksOwned.hasNext()) {
			DeadlockDetectingLock current = (DeadlockDetectingLock) locksOwned
					.next();
			if (current == l)
				return false;
			Iterator waitingThreads = getAllThreadsHardwaiting(current);
			while (waitingThreads.hasNext()) {
				Thread otherthread = (Thread) waitingThreads.next();
				if (!canThreadWaitOnLock(otherthread, l)) {
					return false;
				}
			}
		}
		return true;
	}

	public DeadlockDetectingLock() {
		this(false, false);
	}

	public DeadlockDetectingLock(boolean fair) {
		this(fair, false);
	}

	private boolean debugging;

	public DeadlockDetectingLock(boolean fair, boolean debug) {
		super(fair);
		debugging = debug;
		registerLock(this);
	}

	public void lock() {
		if (isHeldByCurrentThread()) {
			if (debugging)
				System.out.println("Already Own Lock");
			super.lock();
			freeIfHardwait(hardwaitingThreads, Thread.currentThread());
			return;
		}
		markAsHardwait(hardwaitingThreads, Thread.currentThread());
		if (canThreadWaitOnLock(Thread.currentThread(), this)) {
			if (debugging)
				System.out.println("Waiting For Lock");
			super.lock();
			freeIfHardwait(hardwaitingThreads, Thread.currentThread());
			if (debugging)
				System.out.println("Got New Lock");
		} else {
			throw new DeadlockDetectedException("DEADLOCK");
		}
	}

	public void lockInterruptibly() throws InterruptedException {
		lock();
	}

	public class DeadlockDetectingCondition implements Condition {
		Condition embedded;

		protected DeadlockDetectingCondition(ReentrantLock lock, Condition e) {
			embedded = e;
		}

		public void await() throws InterruptedException {
			try {
				markAsHardwait(hardwaitingThreads, Thread.currentThread());
				embedded.await();
			} finally {
				freeIfHardwait(hardwaitingThreads, Thread.currentThread());
			}
		}

		public void awaitUninterruptibly() {
			markAsHardwait(hardwaitingThreads, Thread.currentThread());
			embedded.awaitUninterruptibly();
			freeIfHardwait(hardwaitingThreads, Thread.currentThread());
		}

		public long awaitNanos(long nanosTimeout) throws InterruptedException {
			try {
				markAsHardwait(hardwaitingThreads, Thread.currentThread());
				return embedded.awaitNanos(nanosTimeout);
			} finally {
				freeIfHardwait(hardwaitingThreads, Thread.currentThread());
			}
		}

		public boolean await(long time, TimeUnit unit)
				throws InterruptedException {
			try {
				markAsHardwait(hardwaitingThreads, Thread.currentThread());
				return embedded.await(time, unit);
			} finally {
				freeIfHardwait(hardwaitingThreads, Thread.currentThread());
			}
		}

		public boolean awaitUntil(Date deadline) throws InterruptedException {
			try {
				markAsHardwait(hardwaitingThreads, Thread.currentThread());
				return embedded.awaitUntil(deadline);
			} finally {
				freeIfHardwait(hardwaitingThreads, Thread.currentThread());
			}
		}

		public void signal() {
			embedded.signal();
		}

		public void signalAll() {
			embedded.signalAll();
		}
	}

//	public Condition newCondition() {
//		return new DeadlockDetectingCondition(this);
//	}
}