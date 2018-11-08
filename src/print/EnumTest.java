package print;

public class EnumTest {

	public static enum Enum {
		A(1), B(2), C(3), D(4);
		Enum(int i) {
			this.value = i;
		}

		public int getValue() {
			return value;
		}

		private int value;
	}

	private Enum e;

	public Enum getEnum() {
		return e;
	}

	public void setEnum(Enum e) {
		this.e = e;
	}

	public static void main(String[] args) {
		EnumTest en1 = new EnumTest();
		en1.setEnum(EnumTest.Enum.A);
		EnumTest en2 = new EnumTest();
		en2.setEnum(EnumTest.Enum.A);
		System.out.println(en1.getEnum().getValue() == en2.getEnum().getValue());// 可以用等号判断
		System.out.println(en1.getEnum().equals(en2.getEnum()));
		System.out.println(en1.getEnum());
		System.out.println(en1.getEnum().getValue());
	}

}
