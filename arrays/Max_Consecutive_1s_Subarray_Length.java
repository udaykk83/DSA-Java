package arrays;

import java.util.*;

public class Max_Consecutive_1s_Subarray_Length {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 1, 1, 1, 0, 1, 1, 1, 0, 1 };
		System.out.println(Arrays.toString(arr));
		int n = arr.length;

		int[] prefixArray = calculatePrefixArray(arr);
		int[] suffixArray = calculateSuffixArray(arr);

		int sum = 0;
		for (int val : arr) {
			sum = sum + val;
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				int l = prefixArray[i], r = suffixArray[i + 1];
				if (l + r < sum) {
					ans = Math.max(ans, l + r + 1);
				} else {
					ans = Math.max(ans, l + r);
				}
			}
		}
		System.out.println(ans);
	}

	private static int[] calculateSuffixArray(int[] arr) {
		int n = arr.length;
		int[] sufx = new int[n + 1];
		int countOfOnes = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] == 0) {
				countOfOnes = 0;
			} else {
				countOfOnes++;
			}
			sufx[i] = countOfOnes;
		}
		System.out.println(Arrays.toString(sufx));
		return sufx;
	}

	private static int[] calculatePrefixArray(int[] arr) {
		int n = arr.length;
		int[] pre = new int[n + 1];
		int countOfOnes = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				countOfOnes = 0;
			} else {
				countOfOnes++;
			}
			pre[i + 1] = countOfOnes;
		}
		System.out.println(Arrays.toString(pre));
		return pre;
	}

}
