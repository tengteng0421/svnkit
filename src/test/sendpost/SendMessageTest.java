package test.sendpost;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URLEncoder;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import utils.SendMessage;

public class SendMessageTest {

	static String preUrl = "http://127.0.0.1:8080//main/clouddata?";

	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		String sourcePath = "D:/0滕腾文件夹0/01福瑞电子文件/11我的文件/20181204-甘其毛都增加政府统计/其他文件/logs/logs1/log.txt";
		try {
			SendMessageTest s = new SendMessageTest();
			br = new BufferedReader(new FileReader(new File(sourcePath)));
			s.sendData(sourcePath, 4001, 4060, 1000);
			// String line = br.readLine();
			// String subLine = line.substring(line.indexOf("{"));
			// System.out.println(subLine);
			// String string = s.formatUrl(subLine);
			// System.out.println(string);
		} finally {
			br.close();
		}
	}

	public void sendData(String sourcePath, int startLine, int endLine, int intervalMillSeconds) {
		BufferedReader bis = null;
		try {
			bis = new BufferedReader(new FileReader(new File(sourcePath)));

			String line = null;
			int count = 0;
			while ((line = bis.readLine()) != null) {
				count++;
				if (count > endLine) {
					break;
				}
				if (count < startLine) {
					continue;
				}

				// 整理成url
				String url = formatUrl(preUrl, line.substring(line.indexOf("{")));
				// 发送url
				SendMessage.sendJson(url);
				Thread.sleep(intervalMillSeconds);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String formatUrl(String prexPath, String line) throws UnsupportedEncodingException {
		String all = line.replaceAll("\\[", "").replaceAll("\\]", "");
		Map parse = (Map) JSONObject.parse(all);
		System.out.println(parse);
		StringBuffer sb = new StringBuffer();
		boolean flag = false;
		for (Object object : parse.keySet()) {
			System.out.println(object + " " + parse.get(object));

			if (flag) {
				sb.append("&");
			}
			sb.append(object + "=" + URLEncoder.encode(parse.get(object).toString(), "UTF-8"));
			if (!flag) {
				flag = true;
			}
		}
		return prexPath + sb.toString();
	}

}
