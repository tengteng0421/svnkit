package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadText {
	public static String txt2String(File file) {
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
				result.append(System.lineSeparator() + s);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String path = "C:\\Users\\Administrator\\Desktop\\stop1.txt";
		File f = new File(path);
		String txt2String = txt2String(f);
		// System.out.println(txt2String);
		String[] txt2strs = txt2strs(txt2String);
		System.out.println(txt2strs.length);
		int count = 0;
		// for (String string : txt2strs) {
		// System.out.println(++count + " " + string);
		// System.out.println();
		// }
		StringBuffer sb = new StringBuffer();
		for (String string : txt2strs) {
			if (string.contains(",active,")) {
				count++;
				sb.append(string.split(",")[1] + ",");
			}
		}
		System.out.println(count);
		System.out.println(sb.toString());
	}

	private static String[] txt2strs(String txt2String) {
		return txt2String.split("\r\n");

	}
}
