package test;

import java.util.ArrayList;

public class ConcurrentModiTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		new Thread() {
			@Override
			public void run() {
				for (Integer integer : list) {
					System.out.println(integer);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();

		for (int i = 0; i < 10000; i++) {
			list.add(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
