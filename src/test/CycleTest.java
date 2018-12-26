package test;

import java.util.Scanner;

public class CycleTest {
	public static void main(String[] args) {
		for (int i = Integer.MAX_VALUE - 3; i > -1; i++) {
			System.out.print(i + "\t");
		}
		System.out.println("\ninput: ");
		Scanner s = new Scanner(System.in);
		int nextInt = s.nextInt();
		System.out.println(nextInt);

	}
}
