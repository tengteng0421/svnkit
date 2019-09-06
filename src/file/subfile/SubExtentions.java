package file.subfile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import file.ReadText;
import file.WriteToFile;

public class SubExtentions {
	static Set<String> set = new HashSet<>();
	static List<Extention> exts = new ArrayList<>();

	public static void readFile2Map(String path) {
		File f = new File(path);
		String txt2String = ReadText.txt2String(f);
		// System.out.println(txt2String);
		String[] txt2strs = ReadText.txt2strs(txt2String);
		for (String str : txt2strs) {
			if (str.isEmpty()) {
				continue;
			}
			String[] split = str.split("@");
			String jar = split[0].trim();
			String pointId = split[2];
			String[] split2 = split[1].split("=");
			String pluginId = split2[1];
			String functionId = split2[0];
			Extention e = new Extention(jar, pointId, pluginId, functionId);
			exts.add(e);
			set.add(pointId);
		}
	}

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Administrator\\Desktop\\allExtentions.txt";
		readFile2Map(path);
		// pointId种类
		System.out.println("set size: " + set.size());
		for (String string : set) {
			System.out.println(string);
		}
		// 排序
		Extention[] array = exts.toArray(new Extention[exts.size()]);
		Arrays.sort(array, new Comparator<Extention>() {

			@Override
			public int compare(Extention o1, Extention o2) {
				int compareTo = o1.pointId.compareTo(o2.pointId);
				if (compareTo == 0) {
					int compareTo2 = o1.jar.compareTo(o2.jar);
					if (compareTo2 == 0) {
						return o1.functionId.compareTo(o2.functionId);
					}
					return compareTo2;
				}
				return compareTo;
			}
		});
		// 输出
		String outPath = "C:\\Users\\Administrator\\Desktop\\allExtentions2.txt";
		StringBuffer sb = new StringBuffer();
		for (Extention e : array) {
			sb.append(e.jar);
			sb.append("@");
			sb.append(e.functionId);
			sb.append("@");
			sb.append(e.pluginId);
			sb.append("@");
			sb.append(e.pointId);
			sb.append("\r\n");
		}
		WriteToFile.writeToFile(sb.toString(), outPath);

	}
}

class Extention {
	String jar = null;
	String pointId = null;
	String pluginId = null;
	String functionId = null;

	public Extention(String jar, String pointId, String pluginId, String functionId) {
		this.jar = jar;
		this.pointId = pointId;
		this.pluginId = pluginId;
		this.functionId = functionId;
	}
}
