package print;

public class StaticTest {

	private int count;

	public StaticTest(int i) {
		new Builder(i);
		this.count = i;
	}

	public int geti() {
		return count;
	}

	public static class Builder {
		public Builder(int i) {
			this.count = i;
		}

		private int count;

		public int geti() {
			return count;
		}
	}

	public static void main(String[] args) {
		// StaticTest st1 = new StaticTest(1);
		// StaticTest st2 = new StaticTest(2);
		// System.out.println(st1.geti() + " " + st2.geti());
		SingletonTest s1 = SingletonTest.instance(2);
		s1.printi();
		SingletonTest s2 = SingletonTest.instance(5);
		s1.printi();
		s2.printi();
	}
}
