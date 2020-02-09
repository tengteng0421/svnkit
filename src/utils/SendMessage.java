package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

public class SendMessage {
	public static void main(String[] args) throws IOException {
		String path = "http://127.0.0.1:8080/main/clouddata?functionId=cloudData&method=vehicleCloudState&velicenseno=1329%D0%A3%D0%9D%D0%97&enterout=0&grosswt=25260&outtime=2018-11-29%2016%3A31%3A51&channo=1&entertime=2018-11-29%2016%3A31%3A51";
		sendJson(path);
	}

	public static void sendJson(String urlPath)
			throws MalformedURLException, IOException, ProtocolException, UnsupportedEncodingException {
		// String encode = URLEncoder.encode(urlPath, "UTF-8");
		URL url = new URL(urlPath);
		URLConnection con = url.openConnection();
		HttpURLConnection httpCon = (HttpURLConnection) con;
		httpCon.setRequestMethod("POST");
		httpCon.connect();
		InputStream inputStream = httpCon.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "gb2312"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}

}
