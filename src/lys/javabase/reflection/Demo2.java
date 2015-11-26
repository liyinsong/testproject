package lys.javabase.reflection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

//反射类的方法
public class Demo2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Demo2 dem = new Demo2();
		dem.test5();
	}

	public void test() throws Exception{
		Person person = new Person();
		Class personClass = Class.forName("lys.javabase.reflection.Person");
		
		Method method = personClass.getMethod("t1", null);
		method.invoke(person, null);
	}
	
	public void test1() throws Exception{
		Person person = new Person();
		Class personClass = Class.forName("lys.javabase.reflection.Person");
		
		Method method = personClass.getMethod("t2", String.class, int.class);
		method.invoke(person, "haha", 12);
	}
	
	public void test2() throws Exception{
		Person person = new Person();
		Class personClass = Class.forName("lys.javabase.reflection.Person");
		
		Method method = personClass.getMethod("t3", String.class, int[].class);
		Class[] classes = (Class[]) method.invoke(person, "haha", new int[]{1,2,3});
		System.out.println(classes[0]);
	}
	
	public void test3() throws Exception{
		Person person = new Person();
		Class personClass = Class.forName("lys.javabase.reflection.Person");
		
		Method method = personClass.getDeclaredMethod("t4", InputStream.class);
		method.setAccessible(true);
		method.invoke(person, new FileInputStream("note"));
	}
	
	public void test4() throws Exception{
		//Person person = new Person(); 静态方法不需要对象
		Class personClass = Class.forName("lys.javabase.reflection.Person");
		
		Method method = personClass.getMethod("t5", int.class);
		method.invoke(null, 123);
	}
	
	public void test5() throws Exception{
		Class personClass = Class.forName("lys.javabase.reflection.Person");
		
		Method method = personClass.getMethod("main", String[].class);
		//1. 目的是为了兼容jdk1.4
		//method.invoke(null, new Object[]{new String[]{"1"}});
		//2.
		method.invoke(null, (Object)new String[]{"1"});
	}
}
