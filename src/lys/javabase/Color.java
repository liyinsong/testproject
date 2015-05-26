package lys.javabase;

public enum Color {

	RED("hongse", 1), WHITE("baise", 2), BULE("lanse", 3);
	
	private String name;
	
	private int index;
	
	private Color(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}
