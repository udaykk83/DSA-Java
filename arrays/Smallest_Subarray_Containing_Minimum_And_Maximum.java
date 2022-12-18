package arrays;

public class Smallest_Subarray_Containing_Minimum_And_Maximum {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 5, 9, 7, 1, 9, 4 };
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int ans = Integer.MAX_VALUE;
		for (int val : arr) {
			if (val <= min) {
				min = Math.min(min, val);
			}
			if (val >= max) {
				max = Math.max(max, val);
			}
		}
		System.out.println(min + " " + max);
		int min_i = -1;// Integer.MIN_VALUE;
		int max_i = -1;// Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == min) {
				min_i = i;
				ans = Math.min(ans, min_i - max_i + 1);
				System.out.println(i + "  " + min_i + " " + max_i + " " + ans);
			}
			if (arr[i] == max) {
				max_i = i;
				ans = Math.min(ans, max_i - min_i + 1);
				System.out.println(i + "  " + min_i + " " + max_i + " " + ans);
			}
			System.out.println("over");
		}
		System.out.println(ans);
	}

}
