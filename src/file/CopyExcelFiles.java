package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

public class CopyExcelFiles {
	public static final String prefix = "D:/0滕腾文件夹0/22工作日报/";
	public static final String fileName = "滕腾日报";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	Scanner input = new Scanner(System.in);

	@Test
	public void copyExcel() throws IOException, ParseException {

		String source = "";
		String target = "";
		source = getAutoSource(source);
		target = getAutoTarget(target);
		copyExcel(source, target);
	}

	private String getAutoTarget(String target) {
		if (!target.isEmpty()) {
			return target;
		}

		StringBuffer sb = new StringBuffer();
		sb.append(fileName);
		sb.append("(");
		sb.append(getWeek());
		sb.append(")");
		sb.append(sdf.format(new Date()));
		sb.append(".xlsx");
		System.out.println("target: " + sb.toString());
		return sb.toString();
	}

	private String getWeek() {
		int i = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		switch (i) {
		case 1:
			return "周日";
		case 2:
			return "周一";
		case 3:
			return "周二";
		case 4:
			return "周三";
		case 5:
			return "周四";
		case 6:
			return "周五";
		case 7:
			return "周六";
		}
		return "";
	}

	private String getAutoSource(String source) throws ParseException {
		if (!source.isEmpty()) {
			return source;
		}
		File f = new File(prefix);
		String[] list = f.list();
		String result = "滕腾日报模板.xlsx";
		Date max = null;
		for (String string : list) {
			if (string.matches("滕腾日报.+\\d{8}\\.xlsx")) {
				Date date = sdf.parse(string.substring(8, 16));
				if (max == null) {
					max = date;
					result = string;
				} else {
					if (max.getTime() < date.getTime()) {
						max = date;
						result = string;
					}
				}
			}
		}
		System.out.println("source: " + result);
		return result;
	}

	private void copyExcel(String source, String target) throws IOException {
		if (source.equals(target)) {
			System.out.println("source和target相同, 今日日报已生成");
			return;
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			File f = new File(prefix + source);
			if (!f.exists()) {
				return;
			}
			fis = new FileInputStream(f);
			File fileout = new File(prefix + target);
			fos = new FileOutputStream(fileout);
			byte[] buf = new byte[1024 * 10];
			int len = -1;
			while ((len = fis.read(buf)) > 0) {
				fos.write(buf, 0, len);
			}
			fos.flush();
			System.out.println("复制是否成功: " + fileout.exists());
			System.out.println("输入y打开文件:");
			String next = input.next();
			if ("y".equals(next)) {
				Runtime.getRuntime().exec("cmd /c start " + fileout.getAbsolutePath());
			}
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
	}

	public static void main(String[] args) throws IOException, ParseException {
		CopyExcelFiles c = new CopyExcelFiles();
		c.copyExcel();
	}
}
