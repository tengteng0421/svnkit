package file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteToFile {
	public static void writeToFile(String source, String outPath) throws IOException {
		Writer writer = new FileWriter(outPath);
		writer.write(source);
		writer.flush();
		writer.close();
	}
}
