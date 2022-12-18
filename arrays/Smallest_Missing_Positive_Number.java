package arrays;

import java.util.Arrays;

class Smallest_Missing_Positive_NumberSol {

	public void bySortMethod(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		int i = 0;
		for (i = 0; i < n; i++) {
			if (arr[i] > 0) {
				break;
			}
		}
		if (i == n) {
			System.out.println(-1);
			return;
		}
		if (arr[i] != 1) {
			System.out.println(1);
			return;
		}
		for (i = i + 1; i < n; i++) {
			if (arr[i] - arr[i - 1] > 1) {
				System.out.println(arr[i - 1] + 1);
				break;
			}
		}
		if (i == n) {
			System.out.println(n+1);
			return;
		}
	}

}

public class Smallest_Missing_Positive_Number {

	public static void main(String[] args) {
		Smallest_Missing_Positive_NumberSol sol = new Smallest_Missing_Positive_NumberSol();
		int arr[] = new int[] { 2, 3, 7, 6, 8, 1, -10, 15 };
		sol.bySortMethod(arr);
	}

}
