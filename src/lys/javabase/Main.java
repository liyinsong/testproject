package lys.javabase;

import java.util.Objects;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee em = new Employee("male", "test");
		System.out.println(em.hashCode());
		
		Employee em1 = new Employee("male1", "test1");
		System.out.println(em1.hashCode());
		
		System.out.println(Objects.hashCode(em1));
		
		
		em.testArgus("a", "b", "c");
		
		testEnum();
	}
	
	public static void testEnum () {
		
		System.out.println("================");
		System.out.println(Color.BULE);
		
		//System.out.println(Enum.valueOf(Color.class, "ss"));
	}

}
