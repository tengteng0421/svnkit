package svn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

import cn.sy.frdz.svn.SVN;
import svn.utils.XmlUtils;

public class XmlFilesUpdate {
	static String svnRoot = "svn://192.168.199.197/svnroot/";
	static String username = "tengt";
	static String password = "wdmms:GBBESWDW1";

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, SAXException, DocumentException, IOException {
		// 获得svn
		SVN.auth(svnRoot, username, password);
		// String files = "D:/0滕腾文件夹0/01福瑞电子文件/44打版xml/内蒙打版/";
		String files = "D:/0滕腾文件夹0/01福瑞电子文件/44打版xml/甘其毛都打版/";
		// String files = "D:/0滕腾文件夹0/01福瑞电子文件/44打版xml/策克打版/";
		// String files = "D:/0滕腾文件夹0/01福瑞电子文件/44打版xml/美华打版/";
		String[] xmlPaths = XmlUtils.getAllXmlPaths(files);
		for (String string : xmlPaths) {
			updateAllXml(string);
		}

	}

	@SuppressWarnings("rawtypes")
	private static void updateAllXml(String xmlpath)
			throws DocumentException, UnsupportedEncodingException, FileNotFoundException, IOException {
		if (!xmlpath.contains(".xml")) {
			return;
		}
		// 读取xml
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(xmlpath));
		Element root = document.getRootElement();
		List elements = root.elements();
		// 解析修改xml
		updateVersion(elements);
		// 写入xml
		writeXml(document, xmlpath);
	}

	/**
	 * 修改version
	 * 
	 * @param elements
	 * @param xmlpath
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	private static void updateVersion(List elements) {
		for (Object object : elements) {
			Element e = (Element) object;
			String tagPath = "";
			if ("Framework".equals(e.getName())) {
				tagPath = "/tag/frameworks/";
			} else if ("App".equals(e.getName())) {
				tagPath = "/tag/applications/";
			} else {
				continue;
			}
			// 修改document
			List<String> svnDirEntryNames = SVN.getSVNDirEntryNames(tagPath + e.attributeValue("name"));
			String newVersion = svnDirEntryNames.get(0);
			if (!e.attributeValue("version").equals(newVersion)) {
				System.out.println(e.attributeValue("name") + " newVersion: " + newVersion + " oldVersion: "
						+ e.attributeValue("version"));
				e.setAttributeValue("version", newVersion);
				System.out.println();
			}
		}
	}

	/**
	 * 写入xml
	 * 
	 * @param xmlpath
	 */
	private static void writeXml(Document document, String xmlpath)
			throws UnsupportedEncodingException, FileNotFoundException, IOException {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream(xmlpath), format);
		writer.write(document);
		writer.close();
	}

}
