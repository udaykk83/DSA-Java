package searching;

public class Binary_Search_Implementation {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 6, 8, 9, 10 };
		int k = 5;
		System.out.println(findElement(arr, k));
	}

	private static int findElement(int[] arr, int k) {
		int n = arr.length;
		int l = 0, r = n - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == k) {
				return mid;
			} else if (arr[mid] < k) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

}
