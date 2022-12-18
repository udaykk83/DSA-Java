package arrays;

import java.util.Scanner;

public class BasicSyntax {
	static int ab = 10;

	public static void main(String[] args) {
		int[] a = new int[5];
		for (int i = 1; i < 3; i++) {
			a[i] = a[i - 1] + ab;
			ab += 10;

		}

		fun(a);
	}

	private static void fun(int[] a) {
		a[a.length-1] = 2;
		for (int v : a) {
			System.out.println(v);
		}
		System.out.println(ab);
	}

}
