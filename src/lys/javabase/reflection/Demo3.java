package lys.javabase.reflection;

import java.lang.reflect.Field;

//反射字段
public class Demo3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Demo3 de = new Demo3();
		de.test2();
	}

	public void test() throws Exception{
		Person p = new Person();
		
		Class personClass = Class.forName("lys.javabase.reflection.Person");
		Field name = personClass.getField("name");
		Object na = name.get(p);
		Class type = name.getType();
		if(type.equals(String.class)) {
			String value =  (String)na;
			System.out.println(value);
		}
		
		//设置字段值
		name.set(p, "****");
		System.out.println(p.name);
	}
	
	public void test1() throws Exception{
		Person p = new Person();
		
		Class personClass = Class.forName("lys.javabase.reflection.Person");
		Field name = personClass.getDeclaredField("password");
		name.setAccessible(true);
		
		
		System.out.println(name.get(p));
	}
	
	public void test2() throws Exception{
		
		Class personClass = Class.forName("lys.javabase.reflection.Person");
		Field name = personClass.getDeclaredField("age");
		name.setAccessible(true);
		
		System.out.println(name.get(null));
	}
}
