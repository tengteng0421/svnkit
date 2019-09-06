package file.subfile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import file.ReadText;

public class AddTitle {
	public static void main(String[] args) {
		// 读取文件
		String xiugaiPath = "C:\\Users\\Administrator\\Desktop\\xiugai1.txt";
		String txt2String = ReadText.txt2String(new File(xiugaiPath));
		String[] xiugais = ReadText.txt2strs(txt2String);

		String yuanPath = "C:\\Users\\Administrator\\Desktop\\yuan.txt";
		String ss = ReadText.txt2String(new File(yuanPath));
		String[] yuans = ReadText.txt2strs(ss);

		String xianchangPath = "C:\\Users\\Administrator\\Desktop\\xianchang.txt";
		String sss = ReadText.txt2String(new File(xianchangPath));
		String[] xianchang = ReadText.txt2strs(sss);

		// 截取文件
		Map<String, String> mapGuojihua = new HashMap<>();
		for (String string : yuans) {
			if (string.isEmpty()) {
				continue;
			}
			String substring = string.substring(string.indexOf('@'));
			String key = substring.substring(0, substring.indexOf('\t')).substring(substring.indexOf('_') + 1);
			String value = substring.substring(substring.indexOf('\t')).trim();
			mapGuojihua.put(key, value);
			// System.out.println(key + "\t" + value);
		}
		Map<String, String> mapXianchang = new HashMap<>();
		for (String string : xianchang) {
			if (string.isEmpty()) {
				continue;
			}
			String[] split = string.split("_");
			mapXianchang.put(split[0], split[1]);
		}

		// 重写题目
		StringBuffer sb = new StringBuffer();
		for (String string : xiugais) {
			boolean containsKey = mapGuojihua.containsKey(string);
			boolean containsKey2 = mapXianchang.containsKey(string);
			sb.append(string);
			if (containsKey) {
				sb.append('_');
				sb.append(mapGuojihua.get(string));
			}
			if (containsKey2) {
				sb.append('_');
				sb.append(mapXianchang.get(string));
			}
			sb.append("\r\n");
		}

		System.out.println(sb.toString());
	}
}
