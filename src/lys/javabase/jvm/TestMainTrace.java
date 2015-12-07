package lys.javabase.jvm;

import java.util.Vector;

public class TestMainTrace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		byte[] b = new byte[10 * 1024 * 1024];
//		
//		System.out.println(Runtime.getRuntime().maxMemory() /1024/1024);
//		System.out.println(Runtime.getRuntime().freeMemory() /1024/1024);
//		System.out.println(Runtime.getRuntime().totalMemory() /1024/1024);
		
		/*
		 * 3641
		 * 241
		 * 245
		 */
		//-Xmx20m -Xms20m -Xmn1m -XX:+PrintGCDetails
//		byte[] b = null;
//		for (int i =0; i<10; i++) {
//			b = new byte[1 * 1024 *1024];
//		}
	}
	
	public static void testOutOfMemory() {
		
		/*
		 * jvm:
		 * -Xmx20m -Xms5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/liyinsong/git/testproject/src/lys/javabase/jvm/a.dump
		 */
		Vector v = new Vector();
		for (int i = 0; i<2500; i++) {
			v.add(new byte[1 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024]);
		}
	}

}
