package lys.javabase.synchronization;

public class Main {

	public static void main(String[] args) {
		
		MyThread my = new MyThread();
		
		Thread t1 = new Thread(my);
		Thread t2 = new Thread(my);

		t1.start();
		t2.start();
	}

}
