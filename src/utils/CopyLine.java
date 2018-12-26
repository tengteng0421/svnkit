package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CopyLine {
	public static void main(String[] args) throws IOException {
		String path = "C:/Users/Administrator/Desktop/logs/logs1/";
		String outPath = "C:/Users/Administrator/Desktop/logs/logs1/log.txt";
		miltiCopy(path, outPath, true);
		// copySpecialLine(path, outPath, false);
	}

	private static void miltiCopy(String sourceFiles, String targetFiles, boolean isAppend)
			throws FileNotFoundException, IOException {
		File f = new File(sourceFiles);
		File[] files = f.listFiles();
		for (File file : files) {
			if (!file.isDirectory()) {
				File f2 = new File(targetFiles);
				String fileName = targetFiles;
				if (!f2.exists()) {
					f2.createNewFile();
				}
				if (f2.isDirectory()) {
					fileName = targetFiles + file.getName();
				}
				File f1 = new File(fileName);
				if (!f1.exists()) {
					f1.createNewFile();
				}
				copySpecialLine(file.getAbsolutePath(), fileName, isAppend, "甘其毛都口岸货运");
			}
		}
	}

	private static void copySpecialLine(String sourcePath, String targetPath, boolean isAppend)
			throws FileNotFoundException, IOException {
		String path = sourcePath;
		String outPath = targetPath;
		InputStreamReader isr = new InputStreamReader(new FileInputStream(path));
		BufferedReader br = new BufferedReader(isr);
		String readLine = "";
		List<String> list = new ArrayList<>();
		while ((readLine = br.readLine()) != null) {
			if (readLine.contains("\"functionId\":[\"cloudData\"]")) {
				System.out.println(readLine);
				list.add(readLine);
			}
		}
		br.close();
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outPath, isAppend));
		BufferedWriter bw = new BufferedWriter(osw);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			bw.write(list.get(i));
			bw.newLine();
		}
		bw.close();
	}

	private static void copySpecialLine(String sourcePath, String targetPath, boolean isAppend, String contains)
			throws FileNotFoundException, IOException {
		String path = sourcePath;
		String outPath = targetPath;
		InputStreamReader isr = new InputStreamReader(new FileInputStream(path));
		BufferedReader br = new BufferedReader(isr);
		String readLine = "";
		List<String> list = new ArrayList<>();
		while ((readLine = br.readLine()) != null) {
			if (readLine.contains(contains)) {
				System.out.println(readLine);
				list.add(readLine);
			}
		}
		br.close();
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outPath, isAppend));
		BufferedWriter bw = new BufferedWriter(osw);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			bw.write(list.get(i));
			bw.newLine();
		}
		bw.close();
	}
}
