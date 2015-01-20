package lys.test.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestSynchronized {
	
	static Set set = Collections.synchronizedSet(new HashSet());
	static boolean run = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("*******This is a thread********");
			
				System.out.println("Is Set add element successfully? "
						+ (set.add("lan") ? "Yes" : "No"));
			}
		});
		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("*******This is b thread********");
			
				System.out.println("Is Set add element successfully? "
						+ (set.add("lan") ? "Yes" : "No"));
			
			}
		});
		Thread c = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("*******This is c thread********");
			
				System.out.println("Is Set add element successfully? "
						+ (set.add("lan") ? "Yes" : "No"));
			}
		});
		a.start();
		b.start();
		c.start();
		Thread d = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("set----->" + set);
			}
		});
		while (run) {
			if ((!a.isAlive()) && (!b.isAlive()) && (!c.isAlive())) {
				if (!d.isAlive()) {
					run = false;
					d.start();
				}
			}
		}
	}
}