package test;

public class ThreadTest2 extends Thread {

	boolean flag = true;

	@Override
	public void run() {
		System.out.println("flag:::" + flag);
		while (flag) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			continue;
		}
		System.out.println("thread exit");
	}

	public static void main(String[] args) {
		ThreadTest2 t = new ThreadTest2();
		System.out.println("alive: " + t.isAlive());
		System.out.println("Daemon: " + t.isDaemon());
		System.out.println("Interrupted: " + t.isInterrupted());
		System.out.println("state" + t.getState());
		System.out.println("1-------------");

		t.start();
		System.out.println("alive: " + t.isAlive());
		System.out.println("Daemon: " + t.isDaemon());
		System.out.println("Interrupted: " + t.isInterrupted());
		System.out.println("state" + t.getState());
		System.out.println("2-------------");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("alive: " + t.isAlive());
		System.out.println("Daemon: " + t.isDaemon());
		System.out.println("Interrupted: " + t.isInterrupted());
		System.out.println("state" + t.getState());
		System.out.println("3-------------");

		t.flag = false;

		System.out.println("flag changed:" + t.flag);

		System.out.println("alive: " + t.isAlive());
		System.out.println("Daemon: " + t.isDaemon());
		System.out.println("Interrupted: " + t.isInterrupted());
		System.out.println("state" + t.getState());
		System.out.println("4-------------");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("alive: " + t.isAlive());
		System.out.println("Daemon: " + t.isDaemon());
		System.out.println("Interrupted: " + t.isInterrupted());
		System.out.println("state" + t.getState());
		System.out.println("5-------------");

		t.run();

	}
}
