package slidingWindow;

public class Maximum_Sum_Subarray_Of_Size_K {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
		int n = arr.length;
		int k = 4;

		int ans = Integer.MIN_VALUE;
		int sum = 0;
		int i = 0;
		int j = 0;
		while (j < n) {
			sum = sum + arr[j];
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				ans = Math.max(ans, sum);
				sum = sum - arr[i];
				i++;
				j++;
			}
		}
		System.out.println(ans);
	}

}
