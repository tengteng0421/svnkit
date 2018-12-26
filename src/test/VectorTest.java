package test;

import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		v.add("1");
		v.add("2");
		v.add("1");
		v.add(null);
		System.out.println(v.toString());
	}
}
