package lys.test.generic;

public class Demo01 {

	public static void main(String[] args) {
		Point<String> p = new Point<String>();
		p.setX("12");
		p.setY("10");
		
		System.out.println("x: " + p.getX() + "  y: " + p.getY());
	}
	
	
}

class Point<T> {

	private T x;
	private T y;
	
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	
	
}