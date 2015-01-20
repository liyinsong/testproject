package lys.test.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestsynchronizedSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create set
		Set<String> set = new HashSet<String>();

		// populate the set
		set.add("TP");
		set.add("IS");
		set.add("FOR");
		set.add("TECHIES");

		// create a synchronized set
		Set<String> synset = Collections.synchronizedSet(set);

		System.out.println("Synchronized set is :" + synset);
	}

}
