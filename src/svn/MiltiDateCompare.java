package svn;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.sy.frdz.svn.SVN;
import svn.utils.XmlUtils;

/**
 * 比较是否有项目需要tag
 * 
 * @author Tengt
 *
 */
public class MiltiDateCompare {
	static String svnRoot = "svn://192.168.199.197/svnroot/";
	static String username = "tengt";
	static String password = "wdmms:GBBESWDW1";
	static String xmlpath = "D:/0滕腾文件夹0/01福瑞电子文件/44打版xml/甘其毛都打版/";
	// static String xmlpath = "D:/0滕腾文件夹0/01福瑞电子文件/44打版xml/内蒙打版/";
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) throws DocumentException, ParseException {
		SVN.auth(svnRoot, username, password);
		// 读取xml
		SAXReader reader = new SAXReader();
		Map<String, Date> apps = SVN.getFilesInfo("/trunk/applications");
		Map<String, Date> frameworks = SVN.getFilesInfo("/trunk/frameworks");
		String[] allXmlPaths = XmlUtils.getAllXmlPaths(xmlpath);
		List<String> results = new ArrayList<>();
		for (String string : allXmlPaths) {
			if (!string.contains(".xml")) {
				continue;
			}
			System.out.println("正在对比文件: " + string);
			List<String> tags = findCompareResults(string, reader, apps, frameworks);
			tags.removeAll(results);
			results.addAll(tags);
		}
		System.out.println("需要tag的项目数量: " + results.size());
		for (String string : results) {
			System.out.println(string);
		}
	}

	private static List<String> findCompareResults(String xmlpath, SAXReader reader, Map<String, Date> apps,
			Map<String, Date> frameworks) throws DocumentException, ParseException {

		Document document = reader.read(new File(xmlpath));
		Element root = document.getRootElement();
		List elements = root.elements();
		List<String> tags = getCompareResult(elements, apps, frameworks);
		return tags;
	}

	private static List<String> getCompareResult(List elements, Map<String, Date> apps, Map<String, Date> frameworks)
			throws ParseException {
		List<String> tags = new ArrayList<>();
		for (Object object : elements) {
			Element e = (Element) object;
			String tagPath = "";
			boolean isApp = false;
			if ("Framework".equals(e.getName())) {
				tagPath = "/tag/frameworks/";
			} else if ("App".equals(e.getName())) {
				tagPath = "/tag/applications/";
				isApp = true;
			} else {
				continue;
			}
			// 比较document
			String tagName = e.attributeValue("name");
			List<String> svnDirEntryNames = SVN.getSVNDirEntryNames(tagPath + tagName);
			String newVersion = svnDirEntryNames.get(0);
			// System.out.println(tagName + " " + newVersion);
			String dateStr = newVersion.substring(newVersion.indexOf("_") + 1);

			long tagTime = sdf.parse(dateStr).getTime();
			Date date = null;
			if (isApp) {
				date = apps.get(tagName);
			} else {
				date = frameworks.get(tagName);
			}
			// 比较时间大小
			if (tagTime < date.getTime()) {
				if (isApp) {
					tags.add("app:" + tagName + " " + sdf2.format(date));
				} else {
					tags.add("framework:" + tagName + " " + sdf2.format(date));
				}
			}
		}
		return tags;
	}
}
