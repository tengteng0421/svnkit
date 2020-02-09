package test;

import org.junit.Test;

public class StringTest {
	public static void main(String[] args) {
		String s = new String("ss");
		String s2 = new String("ss");
		char[] c = { 's', 's' };
		String s3 = new String(c);
		System.out.println(c.hashCode());
		System.out.println(s.hashCode() + " " + s2.hashCode() + " " + s3.hashCode());
	}

	@Test
	public void test1() {
		String str = "http://www.baidu.com/;jsee";
		System.out.println(str.substring(0, str.lastIndexOf(";")));
	}
}
