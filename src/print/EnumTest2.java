package print;

public enum EnumTest2 {
	HIGH("A"), MEDIUM("B"), LOW(3);

	private int count;
	private String str;
	private int num;

	EnumTest2(int i) {
		this.count = i;
		num = 1;
	}

	EnumTest2(String i) {
		this.str = i;
		num = 2;
	}

	public Object getValue() {
		if (num == 1) {
			return count;
		} else {
			return str;
		}
	}

	public static void main(String[] args) {
		System.out.println();
	}
}
