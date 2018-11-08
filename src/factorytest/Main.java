package factorytest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {
	public static void main(String[] args) throws Exception {
		// Creator creator = new ConcreteCreator1();
		// Product factory = creator.factory();
		// System.out.println(0 >> 1);
		// Main m = new Main();
		// while (true) {
		// m.grow(m.count + 1);
		// System.out.println(m.count);
		// }

		// URL 读取
		URL url = new URL("https://www.baidu.com");
		URLConnection openConnection = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
		String inputLine = null;
		while ((inputLine = br.readLine()) != null) {
			System.out.println(inputLine);
		}
	}

	public int count = 0;

	private void grow(int minCapacity) throws Exception {
		// overflow-conscious code
		int oldCapacity = count;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		if (newCapacity < 0 || newCapacity - Integer.MAX_VALUE + 8 > 0) {
			count = Integer.MAX_VALUE - 8;
			System.out.println(count);
			throw new Exception("over");
		}
		count = newCapacity;
	}
}
