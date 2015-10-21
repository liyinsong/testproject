package lys.threads.javathreads.examples.ch02;

public class TestThreadInterrupt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start main thread");
		
		System.out.println("main thread current thread : " + Thread.currentThread());
		
		Thread thr = new Thread(new Thread01());
		Thread thr2 = new Thread(new Thread01());
		
		thr.start();
		thr2.start();
		
		thr.interrupt();
		
//		try {
//			thr.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("end main thread");
	}

}

class Thread01 implements Runnable{

	private int age;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("start...");

		try {
			System.out.println("Thread01 current thread : " + Thread.currentThread());
			Thread.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("interrupt...");
		}
		System.out.println("end...");
	}
	
}