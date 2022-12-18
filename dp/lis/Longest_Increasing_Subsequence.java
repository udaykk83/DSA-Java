package dp.lis;

import java.util.*;

public class Longest_Increasing_Subsequence {

	public static void main(String[] args) {

		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		findLISLength(arr, n);

	}

	private static void findLISLength(int[] arr, int n) {

		// lis holds the max length of the increasing subsequence
		int lis[] = new int[n];
		Arrays.fill(lis, 0);
		int ans = 1;
		if (n == 0) {
			return;
		}
		lis[0] = 1;
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			res.add(new ArrayList<>());
		}
		res.get(0).add(arr[0]);
		for (int i = 1; i < n; i++) {
			int j;
			for (j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j]) {
					// for length
					lis[i] = lis[j];
					// for printing elements
					res.set(i, new ArrayList<>(res.get(j)));
				}
			}
			lis[i]++;
			res.get(i).add(arr[j]);
			ans = Math.max(ans, lis[i]);
		}
		int idx = 0, max = 0;
		for (int i = 0; i < n; i++) {
			int cnt = res.get(i).size();
			if (max < cnt) {
				max = cnt;
				idx = i;
			}
		}

		System.out.println(res.get(idx));

		int k = Arrays.stream(lis).max().getAsInt();
		System.out.println(k);
	}

}
