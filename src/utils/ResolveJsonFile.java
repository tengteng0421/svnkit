package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class ResolveJsonFile {

	static String path = "C:/Users/Administrator/Desktop/log1.txt";
	static String outPath = "C:/Users/Administrator/Desktop/log1226.txt";

	public static void main(String[] args) {
		ResolveJsonFile rjf = new ResolveJsonFile();
		rjf.resolveJson(path, outPath);

	}

	private void resolveJson(String path, String outPath) {
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(path));
			BufferedReader br = new BufferedReader(isr);
			String readLine = "";

			boolean isTail = false;
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outPath, true));
			BufferedWriter bw = new BufferedWriter(osw);
			while ((readLine = br.readLine()) != null) {

			}
			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String createJson(String string) throws UnsupportedEncodingException {
		Map parse = (Map) JSONObject.parse(string);
		// JSONObject object = JSONObject.parseObject(string);
		StringBuffer sb = new StringBuffer();
		for (Object key : parse.keySet()) {
			sb.append("&");
			sb.append(parse + "=" + URLEncoder.encode(parse.get(key).toString(), "UTF-8"));
		}
		return sb.toString();
	}
}
