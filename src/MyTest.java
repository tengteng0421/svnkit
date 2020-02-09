public class MyTest {
	public static void main(String[] args) {
		String s = "";
		String[] split = s.split(",");
		for (String string : split) {
			System.out.println("---" + string);
		}
	}
}
