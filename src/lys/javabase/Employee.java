package lys.javabase;

public class Employee {

	private int nextId = 1;
	
	private int id = 0;
	
	private String sex;
	
	private String name;
	
	{
		id = nextId;
		
		nextId ++;
	}
	
	public Employee(String sex, String name) {
		this.sex = sex;
		this.name = name;
	}

	public Employee() {
		System.out.println("default contructor");
	}
	
	public void testArgus(String... names) {
		for (String name : names) {
			System.out.println(name);
		}
	}
}
