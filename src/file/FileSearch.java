package file;

import java.io.File;

public class FileSearch {

	public File[] searchFiles(String path) {
		// path = "C:/Users/Administrator/Desktop/测试图片";
		File f = new File(path);
		File[] listFiles = f.listFiles();
		for (File file : listFiles) {
			System.out.println("file path: " + file.getAbsolutePath());
		}
		return listFiles;
	}

	// @Test
	public void search() {
		String path = "C:/Users/Administrator/Desktop/测试图片";
		searchFiles(path);
	}
}
