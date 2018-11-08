package print;

import utils.CreateStrings;

public class Test0428 {
	public static void main(String[] args) {
		String s = "123456;789";
		int indexOf = s.indexOf(";");
		String substring = s.substring(0, indexOf >= 0 ? indexOf : s.length());
		System.out.println(substring);

		Test111 t = new Test111();
		t.printTest111();
		CreateStrings c = new CreateStrings();

	}
}
