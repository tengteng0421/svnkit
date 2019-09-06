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

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import utils.SendMessage;

public class SendMessageTest {

	static String preUrl = "http://127.0.0.1:8080//main/clouddata?";
	static String dataPreUrl = "http://192.168.199.71:8091/main/clouddata?functionId=cloudData&method=vehicleCloudState";
	static String[] titles = null;
	// _id,areaname,areano,channame,channo,cloud_id,customname,customno,enterout,entertime,f_create_time,f_id,f_update_time,grosswt,ophint,outtime,releasemode,rfid,velicenseno

	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		String sourcePath = "C:/Users/Administrator/Desktop/CLOUD_DATA_LOG222.csv";
		try {
			SendMessageTest s = new SendMessageTest();
			br = new BufferedReader(new FileReader(new File(sourcePath)));
			s.sendDataFromData(sourcePath, 12, 500, 100);
			// s.sendDataFromLog(sourcePath, 4001, 4060, 1000);
		} finally {
			br.close();
		}
	}

	public void sendDataFromData(String sourcePath, int startLine, int endLine, int intervalMillSeconds) {
		BufferedReader bis = null;
		try {
			bis = new BufferedReader(new FileReader(new File(sourcePath)));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String line = null;
		int count = 0;
		try {
			while ((line = bis.readLine()) != null) {
				try {
					if (titles == null) {
						titles = createTitles(line);
						continue;
					}
					count++;
					if (count > endLine) {
						break;
					}
					if (count < startLine) {
						continue;
					}

					// 整理成url
					String url = formatUrlFromData(dataPreUrl, line, titles);
					System.out.println(url);
					// 发送url
					SendMessage.sendJson(url);
					Thread.sleep(intervalMillSeconds);
				} catch (Exception e) {
					continue;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendDataFromLog(String sourcePath, int startLine, int endLine, int intervalMillSeconds) {
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
				String url = formatUrlFromLog(preUrl, line.substring(line.indexOf("{")));
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

	@Test
	public void test() throws IOException {
		String path = "C:/Users/Administrator/Desktop/log1.txt";
		BufferedReader bis = new BufferedReader(new FileReader(new File(path)));
		String line = null;
		String[] titles = null;
		while ((line = bis.readLine()) != null) {
			if (titles == null) {
				titles = createTitles(line);
				continue;
			}
			String s = createParams(line, titles);
			System.out.println(s);
		}
		bis.close();
	}

	private String createParams(String line, String[] titles) throws UnsupportedEncodingException {
		String[] split = line.split(",");
		StringBuffer sb = new StringBuffer();
		// _id,f_create_time,f_id,f_update_time
		// cloud_id
		for (int i = 0; i < titles.length; i++) {
			if (titles[i].equals("_id") || titles[i].equals("f_create_time") || titles[i].equals("f_update_time")
					|| titles[i].equals("f_id")) {
				continue;
			}
			sb.append("&");
			if (titles[i].equals("cloud_id")) {
				sb.append("id" + "=" + split[i]);
			} else {
				sb.append(titles[i] + "=" + URLEncoder.encode(split[i], "UTF-8"));
			}
		}
		return sb.toString();
	}

	private String[] createTitles(String line) {
		System.out.println(line);
		String[] split = line.split(",");
		return split;
	}

	private String formatUrlFromData(String prexPath, String line, String[] titles)
			throws UnsupportedEncodingException {
		String createParams = createParams(line, titles);
		return prexPath + createParams;

	}

	private String formatUrlFromLog(String prexPath, String line) throws UnsupportedEncodingException {
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
