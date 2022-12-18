package recursion;

import java.util.Arrays;

public class Sort_An_Array {

	public static void main(String[] args) {
		int arr[] = { 1, 5, 2, 9, 3, 4, 8 };
		int n = arr.length;
		System.out.println(Arrays.toString(arr));
		sortArray(arr, n);
		System.out.println(Arrays.toString(arr));
		System.out.println(arr);
	}

	private static void sortArray(int[] arr, int n) {
		if (n == 1) {
			return;
		}
		sortArray(arr, n - 1);
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[n - 1]) {
				int t = arr[i];
				arr[i] = arr[n - 1];
				arr[n - 1] = t;
			}
		}
		System.out.println("n is " + n + " arr " + Arrays.toString(arr));
	}

}
