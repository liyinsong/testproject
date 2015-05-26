package lys.designpattern.proxy;

public class TimeProxy implements Moveable{

	Moveable t;
	
	public TimeProxy(Moveable t) {
		super();
		this.t = t;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Start...");
		t.move();
		System.out.println("End...");
	}

}
