package lys.threads.javathreads.examples.ch09;

public class ThreadTest {
	public static void main(String[] args) {
		int nThreads = Integer.parseInt("3");
		long n = Long.parseLong("3");
		Thread t[] = new Thread[nThreads];
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(new Task(n, "Task " + i));
			t[i].start();
		}
		for (int i = 0; i < t.length; i++) {
			try {
				t[i].join();
			} catch (InterruptedException ie) {
			}
		}
		
		System.out.println("All Done!");
	}
}
