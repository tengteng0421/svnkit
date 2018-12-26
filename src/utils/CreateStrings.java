package utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CreateStrings {
	@Test
	public void createStr() {
		int length = 20;
		int a = 'A';
		int z = 'Z';
		int zero = '0';
		int nine = '9';
		List<Character> list = new ArrayList<>();
		for (int i = a; i <= z; i++) {
			list.add((char) i);
		}
		for (int i = zero; i <= nine; i++) {
			list.add((char) i);
		}
		for (int i = 0; i < length; i++) {
			int num = (int) (Math.random() * list.size());
			System.out.print(list.get(num));
		}
	}

	void createTest() {

	}

}
