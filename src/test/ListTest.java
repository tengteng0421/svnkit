package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<String> list2 = Arrays.asList("aa", "bb", "cc");
		List<String> list1 = new ArrayList<>();
		System.out.println("list1: " + (list1 instanceof ArrayList));
		// System.out.println("list2: " + (list2 instanceof
		// java.util.Arrays.ArrayList));
		// list1.add("aa");
		// list1.add("bb");
		// list1.add("cc");
		// System.out.println(list1);
		// List<String> list2 = new ArrayList<>();
		// list2.add("cc");
		// list2.add("dd");
		// list2.add("ee");
		// list2.removeAll(list1);
		// list1.addAll(list2);
		// list1.retainAll(list2);
		// System.out.println(list1);
	}
}
