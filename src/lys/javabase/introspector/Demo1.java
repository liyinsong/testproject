package lys.javabase.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Demo1 demo = new Demo1();
		demo.test2();
	}

	public void test1() throws Exception {
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
		PropertyDescriptor[] des = beanInfo.getPropertyDescriptors();
		
		for(PropertyDescriptor de : des) {
			System.out.println(de.getName());
		}
	}
	
	public void test2() throws Exception {
		
		Person p = new Person();
		
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		//pd.getPropertyType();
		Method method = pd.getWriteMethod();
		method.invoke(p, 111);
		
		System.out.println(p.getAge());
	}
}
