package utils;

public class OtherWords {
	public static void main(String[] args) {
		String str = "АБВГДЕЁЖЗИЙКЛМНОӨПРСТУҮФХЦЧШЩЪЫЬЭЮЯ";
		String str2 = "АБВГДЕЁЖЗИЙКЛМНО ПРСТУ ФХЦЧШЩЪЫЬЭЮЯ";
		String strl = "абвгдеёжзийклмноөпрстуүфхцчшщъыьэюя";

		// System.out.println(str.length());
		// System.out.println(str2.length());
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			String unicode = getUnicode(String.valueOf(c));
			System.out.println();
			System.out.println(c + " " + unicode);
		}
		// System.out.println(str.toLowerCase());
		// for (int i = 0; i < str.length(); i++) {
		// char charAt = str.charAt(i);
		// System.out.println("<item word=\"" + charAt + "\" zh_cn=\"" + charAt
		// + "\" />");
		// }
	}

	public static String getUnicode(String source) {
		String returnUniCode = null;
		String uniCodeTemp = null;
		for (int i = 0; i < source.length(); i++) {
			uniCodeTemp = "\\u" + Integer.toHexString(source.charAt(i));// 使用char类的charAt()的方法
			returnUniCode = returnUniCode == null ? uniCodeTemp : returnUniCode + uniCodeTemp;
		}
		return returnUniCode;// 返回一个字符的unicode的编码值
	}
}
