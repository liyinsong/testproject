package lys.javabase.reflection;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Test01 t = new Test01();
		t.tt();
		System.out.println();
	}

	private void tt () {
		getClass();
	}
}
