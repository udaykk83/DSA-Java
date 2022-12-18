package hashing;

import java.util.HashMap;

class Largest_Subarray_With_Equal_Number_Of_0s_And_1sSol {

	public void largest_Subarray_With_Equal_Number_Of_0s_And_1s(int[] arr) {

		int n = arr.length;
		int pre[] = new int[n + 2];
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] == 0 ? -1 : 1;
			pre[i + 1] = pre[i] + arr[i];
		}

		int ans = Integer.MIN_VALUE;
		int endIndex = 0;
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (pre[i - 1] == pre[j]) {
					if (ans < j - i + 1) {
						ans = j - i + 1;
						endIndex = j;
					}
				}
			}
		}

		System.out.println(ans + " and range is " + (endIndex - 1 - ans + 1) + "-" + (endIndex - 1));

		HashMap<Integer, Integer> hash = new HashMap<>();
		int sum = 0;
		int res = Integer.MIN_VALUE;
		int idx = -1;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == 0) {
				if (res < i) {
					res = i;
					idx = i;
				}
			}
			if (hash.containsKey(sum)) {
				int var = hash.get(sum);
				if (res < i - var) {
					res = i - var;
					idx = i;
				}
			} else {
				hash.put(sum, i);
			}
		}

		System.out.println(res + " and  values " + (idx - res + 1) + " " + idx);

	}

}

public class Largest_Subarray_With_Equal_Number_Of_0s_And_1s {

	public static void main(String[] args) {

		Largest_Subarray_With_Equal_Number_Of_0s_And_1sSol p = new Largest_Subarray_With_Equal_Number_Of_0s_And_1sSol();
		int arr[] = new int[] { 1, 0, 1, 1, 1, 0, 0 };
		p.largest_Subarray_With_Equal_Number_Of_0s_And_1s(arr);

	}

}
