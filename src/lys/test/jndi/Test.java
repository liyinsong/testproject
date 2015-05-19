package lys.test.jndi;

public class Test {

	public static void main(String[] args) {
		String lineSeparator = SeparatorUtils.getLineSeparator();
		String pathSeparator = SeparatorUtils.getPathSeparator();
		System.out.println("Line separator is: " + SeparatorUtils.getLineSeparator());
		System.out.println("Path separator is: " + SeparatorUtils.getPathSeparator());
	}
}
