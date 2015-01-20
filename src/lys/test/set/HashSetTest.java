package lys.test.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {

		final Set<Integer> set = Collections
				.synchronizedSet(new HashSet<Integer>());
		// 开启A线程向set中放数据
		new Thread(new Runnable() {

			@Override
			public void run() {
				int i;
				while (true) {
					try {
						i = new Random().nextInt(1000);
						System.out.println("准备加入到Set...");
						set.add(i);
						System.out.println("===============加入到Set:" + i);
					} catch (Exception e) {
						e.printStackTrace();
						break;
					}
				}
				System.exit(0);
			}
		}, "A").start();

		// 开启B线程删除set中的数据
		new Thread(new Runnable() {

			@Override
			public void run() {
				Iterator<Integer> iter = null;
				while (true) {
					synchronized (set) {
						try {
							iter = set.iterator();
							System.out.println("=================开始迭代..");
							int i;
							while (iter.hasNext()) {
								System.out.println("准备删除Set....");
								i = iter.next();
								iter.remove();
								System.out.println("删除Set：" + i);
							}
						} catch (Exception e) {
							e.printStackTrace();
							break;
						}
					}
				}
				System.exit(0);
			}
		}, "B").start();
	}
}
