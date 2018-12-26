package svn.utils;

import java.io.File;

public class XmlUtils {
	public static String[] getAllXmlPaths(String parentFilePath) {
		File f = new File(parentFilePath);
		String[] list = f.list();
		for (int i = 0; i < list.length; i++) {
			if (!list[i].contains(".xml")) {
				continue;
			}
			list[i] = parentFilePath + list[i];
		}
		return list;
	}
}
