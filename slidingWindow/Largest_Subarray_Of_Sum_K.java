package slidingWindow;

public class Largest_Subarray_Of_Sum_K {

	public static void main(String[] args) {
		int arr[] = { 10, 5, 2, 7, 1, 9 }, k = 15;

		int n = arr.length;

		int i = 0;
		int j = 0;
		int sum = 0;
		int ans = Integer.MIN_VALUE;
		while (j < n) {
			sum = sum + arr[j];
			if (sum < k) {
				j++;
			} else if (sum == k) {
				ans = Math.max(ans, j - i + 1);
				j++;
			} else {
				while (sum > k) {
					sum = sum - arr[i];
					i++;
				}
				j++;
			}
		}
		System.out.println(ans);
	}

}
