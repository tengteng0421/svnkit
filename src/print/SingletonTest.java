package print;

public class SingletonTest {

	private static SingletonTest instance;
	private int i;

	private SingletonTest() {
	}

	public static SingletonTest instance(int i) {
		if (instance == null) {
			instance = new SingletonTest();
		}
		instance.i = i;
		return instance;
	}

	public void printi() {
		System.out.println(i);
	}

}
