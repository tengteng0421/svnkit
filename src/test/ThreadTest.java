package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
	public int inc = 0;
	Lock lock = new ReentrantLock();

	public void increase() {
		// lock.lock();
		// try {
		inc++;
		// } finally {
		// lock.unlock();
		// }
	}

	/**
	 * @author Tengt
	 * @param args
	 */
	public static void main(String[] args) {
		final ThreadTest test = new ThreadTest();
		for (int i = 0; i < 10; i++) {
			new Thread() {
				@Override
				public void run() {
					for (int j = 0; j < 1000; j++)
						test.increase();
				};
			}.start();
		}

		while (Thread.activeCount() > 1) { // 保证前面的线程都执行完
			System.out.println("remains count: " + Thread.activeCount());
			Thread.yield();
		}
		System.out.println(test.inc);
	}
}
