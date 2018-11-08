package print;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

import org.junit.Test;

import file.FileSearch;

public class FileCopy {
	// @Test
	public void copyImg() {
		File f = new File("C:/Users/Administrator/Desktop/测试图片/db73c5657cee5674a66d6fe1edfe1059.jpg");
		String path = "C:/Users/Administrator/Desktop/测试图片/db73c5657cee5674a66d6fe1edfe1059.jpg";
		String outPath = "D:/img0724";
		byte[] image2byte = image2byte(path);
		byte2image(image2byte, outPath + "/img1.jpg");
		byte2image(image2byte, outPath + "/img2.jpg");
	}

	// 图片到byte数组
	public static byte[] image2byte(String path) {
		byte[] data = null;
		FileImageInputStream input = null;
		try {
			input = new FileImageInputStream(new File(path));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			data = output.toByteArray();
			output.close();
			input.close();
		} catch (FileNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (IOException ex1) {
			ex1.printStackTrace();
		}
		return data;
	}

	// byte数组到图片
	public static void byte2image(byte[] data, String path) {
		if (data.length < 3 || path.equals(""))
			return;
		try {
			FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
			System.out.println("Make Picture success,Please find image in " + path);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex);
			ex.printStackTrace();
		}
	}

	@Test
	public void copyTest() {
		String sourcePath = "C:\\Users\\Administrator\\Desktop\\test";
		// System.out.println(sourcePath);
		String targetPath = "C:\\Users\\Administrator\\Desktop\\test\\target";
		FileSearch fs = new FileSearch();
		File[] sourceFiles = fs.searchFiles(sourcePath);
		for (int i = 0; i < sourceFiles.length; i++) {
			if (sourceFiles[i].isDirectory()) {
				continue;
			}
			String name = sourceFiles[i].getName();
			// System.out.println(name);
			copyTest(targetPath, name, sourceFiles[i]);
		}
	}

	public void copyTest(String targetPath, String name, File sourceFiles) {
		int indexOf = name.indexOf(".");
		System.out.println(name.substring(0, indexOf));
		byte[] image2byte = image2byte(sourceFiles.getAbsolutePath());
		for (int i = 1; i <= 4; i++) {
			byte2image(image2byte, targetPath + "/" + name.substring(0, indexOf) + "2_" + i + name.substring(indexOf));
		}
	}

}
