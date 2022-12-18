package dp.lis;

import java.util.*;

public class Largest_Divisible_Subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 1, 2, 3, 9, 14, 18 };
		System.out.println(largestDivisibleSubset(arr));

	}

	public static List<Integer> largestDivisibleSubset(int[] arr) {
		int n = arr.length;
		int lis[] = new int[n];
		Arrays.fill(lis, 0);
		Arrays.sort(arr);
		int ans = 1;
		if (n == 0) {
			return new ArrayList<>();
		}
		lis[0] = 1;
		int idx = 0;
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			res.add(new ArrayList<>());
		}
		res.get(0).add(arr[0]);

		for (int i = 1; i < n; i++) {
			int j;
			for (j = 0; j < i; j++) {
				if (arr[i] % arr[j] == 0 && lis[i] < lis[j]) {
					// for length
					lis[i] = lis[j];
					// for printing elements
					res.set(i, new ArrayList<>(res.get(j)));
				}
			}
			// increase the length
			lis[i]++;
			// add the current eleemnt into the list
			res.get(i).add(arr[i]);

			if (ans < lis[i]) {
				ans = Math.max(ans, lis[i]);
				idx = i;
			}
		}
		return res.get(idx);
	}

}