package lys.javabase.reflection;

import java.io.InputStream;
import java.util.List;

public class Person {

	public String name = "asdf";
	
	public Person() {
		System.out.println("person");
	}
	
	public Person(String name) {
		System.out.println("person name: " + name);
	}
	
	public Person(String name, int pwd) {
		System.out.println("person name: " + name + " , person password: " + pwd);
	}
	
	private Person(List list) {
		System.out.println("person name: " + name);
	}
	
	public void t1() {
		System.out.println("t1 method");
	}
	
	public void t2(String name, int pwd) {
		System.out.println("person name: " + name + " , person password: " + pwd);
	}
	
	public Class[] t3(String name, int[] pwd) {
		System.out.println("person name: " + name + " , person password: " + pwd);
		return new Class[]{String.class};
	}
	
	private void t4(InputStream in) {
		System.out.println(in);
	}
	
	public static void t5(int a) {
		System.out.println(a);
	}
}
