package arrays;

public class Rotate_Right_An_Array_K_Times {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int n = arr.length;
		if (n == 0) {
			System.out.println("Array is empty");
			return;
		}
		int k = 2;
		k = k % n;
		if (k == 0) {
			return;
		}
		printArray(arr);
		reverseArray(arr, n - k, n - 1);
		reverseArray(arr, 0, n - k - 1);
		reverseArray(arr, 0, n - 1);
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void reverseArray(int[] arr, int l, int r) {
		while (l < r) {
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			l++;
			r--;
		}
	}

}
