package hashing;

import java.util.*;

class Longest_Consecutive_SubsequenceSol {

	public void findLongestLength(int[] arr) {
		int n = arr.length;
		TreeSet<Integer> set = new TreeSet<>();
		for (int val : arr) {
			set.add(val);
		}
		System.out.println(set);

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {

			// check if it's the first number or not
			Boolean isAnyValueLessThanPresent = set.contains(arr[i] - 1);

			if (Boolean.FALSE.equals(isAnyValueLessThanPresent)) {
				int num = arr[i];
				while (set.contains(num)) {
					num++;
				}
				ans = Math.max(ans, num - arr[i]);
			}

		}
		System.out.println(ans);
	}

}

public class Longest_Consecutive_Subsequence {

	public static void main(String[] args) {
		Longest_Consecutive_SubsequenceSol sol = new Longest_Consecutive_SubsequenceSol();
		int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
		sol.findLongestLength(arr);
	}

}
