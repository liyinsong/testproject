package lys.javabase.reflection;

/**
 * 加载类，获得类的字节码
 * @author liyinsong
 *
 */
public class T1 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//加载类的方式：
		//1.	
		Class calss1 = Class.forName("lys.javabase.reflection.Person");
		
		//2.
		Class calss2 = new Person().getClass();
		
		//3.
		Class calss3 = Person.class;
	}

}
