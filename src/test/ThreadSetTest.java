package test;

import java.util.HashSet;
import java.util.Set;

public class ThreadSetTest {
	static Set<String> set = new HashSet<>();
	static char c = 0;

	public static void main(String[] args) {
		Thread t = new Thread() {
			@Override
			public void run() {
				boolean contains = false;
				while (!contains) {
					contains = set.contains("c");
					System.out.println(contains);
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
		while (c < 200) {
			set.add(String.valueOf(c++));
			System.out.println(c);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
