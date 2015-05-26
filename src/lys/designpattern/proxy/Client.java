package lys.designpattern.proxy;

public class Client {

	public static void main(String args[]) {
		Tank t = new  Tank();
		
		LogProxy lp = new LogProxy(t);
		TimeProxy tp = new TimeProxy(lp);
		
		
		tp.move();
	}
}
