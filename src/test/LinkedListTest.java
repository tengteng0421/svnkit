package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LinkedListTest {
	List<String> list = new ArrayList<>();

	public static void main(String[] args) {
		// maptest();
		LinkedListTest t = new LinkedListTest();
		t.list.add("a");
		t.list.add("b");
		t.list.add("c");
		t.list.add("d");
		t.list.add("e");

		List<String> l2 = new ArrayList<>();
		l2.addAll(t.list);
		t.list.remove(1);
		System.out.println("list size: " + t.list.size());
		System.out.println("l2 size: " + l2.size());
		for (String string : l2) {
			System.out.print(string + "\t");
		}
	}

	public List<String> getList() {

		return list;
	}

	private static void maptest() {
		Map<String, String> map = new ConcurrentHashMap<>();
		map.put("1", "qwe");
		map.put("2", "");
		map.put("3", "qwe");
		map.put("4", "");
		map.put("5", "qwe");
		map.put("6", "");
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			if (map.get(string).isEmpty()) {
				map.remove(string);
				System.out.println(string);
			}
		}
	}
}
