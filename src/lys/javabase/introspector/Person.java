package lys.javabase.introspector;

public class Person {

	//有四个属性，还有object的getClass
	private String name;
	private int age;
	private int id;
	
	//bean的属性，bean里面有get或set方法
	
	public String getAb() {
		return "ab";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
