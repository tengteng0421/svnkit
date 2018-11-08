package print;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("rawtypes")
public class TestComparable0604 implements Comparable<TestComparable0604> {

	String str = "";

	public TestComparable0604(String str) {
		this.str = str;
	}

	@Override
	public int compareTo(TestComparable0604 o) {
		return this.str.hashCode() - o.str.hashCode();
	}

	public static void main(String[] args) {
		List<TestComparable0604> list = new ArrayList<>();
		list.add(new TestComparable0604("A"));
		list.add(new TestComparable0604("B"));
		list.add(new TestComparable0604("C"));
		list.add(new TestComparable0604("a"));
		list.add(new TestComparable0604("b"));
		list.add(new TestComparable0604("c"));
		list.add(new TestComparable0604("AB"));
		list.add(new TestComparable0604("ab"));
		list.add(new TestComparable0604("于"));
		list.add(new TestComparable0604("于一"));
		list.add(new TestComparable0604("王"));
		list.add(new TestComparable0604("王一"));
		list.add(new TestComparable0604("李二"));
		list.add(new TestComparable0604("高巫山"));
		list.add(new TestComparable0604("付"));
		list.add(new TestComparable0604("富强"));
		list.add(new TestComparable0604("福"));
		Collections.sort(list);
		for (TestComparable0604 t : list) {
			System.out.println(t.str + " " + t.str.hashCode());
		}
	}

}
