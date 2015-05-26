package lys.javabase.synchronization;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程同步三种方式：1.同步代码块	2.同步方法 3.Lock
 * @author liyinsong
 *
 */
public class MyThread implements Runnable {

	private int flag;
	private Object obj = new Object();

	public void run() {
		//同步代码块：将obj对象或者当前对象上锁
		//synchronized (obj) {
		synchronized (this) {
			for (int i = 0; i < 2; i++) {
				flag = 0;

				System.out.println("开始打饭-" + flag);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				flag = 1;

				System.out.println("打饭结束-" + flag);
			}
		}

	}
	
	//同步方法：同步的锁对象是当前对象，所以其它同步的方法也不可以在未释放锁之前执行。
	public synchronized void eat () {
		for (int i = 0; i < 2; i++) {
			flag = 0;

			System.out.println("开始打饭-" + flag);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			flag = 1;

			System.out.println("打饭结束-" + flag);
		}
	}
	
	public synchronized void method2 () {
		System.out.println("method2");
	}
	
	//使用并发包里的ReentrantLock,互斥锁
	private final ReentrantLock lock = new ReentrantLock();
	
	public synchronized void method3 () {
		lock.lock();	//上锁
		
		System.out.println("method3");
		
		lock.unlock();	//解锁
	}
}