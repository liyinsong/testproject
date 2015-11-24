package lys.javabase.reflection;


import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * 解刨类的构造函数，创建类对象
 * 
 * @author liyinsong
 *
 */
public class Demo1 {

	public static void main(String[] args) throws Exception {
		Demo1 demo = new Demo1();
		/*
		Class personClass = Class.forName("lys.javabase.reflection.Person");
		Constructor constructor = personClass.getConstructor(null);
		Person person = (Person) constructor.newInstance(null);
		System.out.println(person.name);
		 */
		demo.test3();
		
	}

	/**
	 * 有参
	 * @throws Exception
	 */
	public void test() throws Exception{
		Class personClass = Class.forName("lys.javabase.reflection.Person");
		Constructor constructor = personClass.getConstructor(String.class);
		Person person = (Person)constructor.newInstance("aaaaa");
		
	}
	
	public void test1() throws Exception{
		Class personClass = Class.forName("lys.javabase.reflection.Person");
		Constructor constructor = personClass.getConstructor(String.class, int.class);
		Person person = (Person)constructor.newInstance("bbb", 123);
		
	}
	
	public void test2() throws Exception{
		Class personClass = Class.forName("lys.javabase.reflection.Person");
		Constructor constructor = personClass.getDeclaredConstructor(List.class);
		//暴力反射
		constructor.setAccessible(true);
		Person person = (Person)constructor.newInstance(new ArrayList());
		
	}
	
	//创建对象的另外的途径,需要无参的构造函数
	public void test3() throws Exception{
		Class personClass = Class.forName("lys.javabase.reflection.Person");
		Person person = (Person) personClass.newInstance();		
	}
}
