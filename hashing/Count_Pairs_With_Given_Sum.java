package hashing;

import java.util.Arrays;
import java.util.HashMap;

/* Count pairs with given sum
Input:  arr[] = {1, 5, 7, -1}, sum = 6
Output:  2
Explanation: Pairs with sum 6 are (1, 5) and (7, -1)

Input:  arr[] = {1, 5, 7, -1, 5}, sum = 6
Output:  3
Explanation: Pairs with sum 6 are (1, 5), (7, -1) & (1, 5)         

Input:  arr[] = {1, 1, 1, 1}, sum = 2
Output:  6
 */

class Count_Pairs_With_Given_SumSol {

	// Handles duplicates also
	// If Array is sorted/unsorted
	public int getPairsCountByHash(int sum, int arr[]) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		}
		int twice_count = 0;

		for (int i = 0; i < n; i++) {
			if (hm.get(sum - arr[i]) != null)
				twice_count += hm.get(sum - arr[i]);
			if (sum - arr[i] == arr[i])
				twice_count--;
		}
		// return the half of twice_count
		return twice_count / 2;
	}
}

class Count_Pairs_With_Given_DiffSol {
	// if x-y = k, then x = y+k or y = x-k , two possibilities, so two conditions
	// Handles Duplicates also
	public int getPairsCountByHash(int target, int arr[]) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int n = arr.length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			while (i + 1 < n && arr[i] == arr[i + 1]) {
				i++;
			}
			if (hm.containsKey(target - arr[i])) {
				ans++;
			}
			if (hm.containsKey(arr[i] - target)) {
				ans++;
			}
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		}
		return ans;
	}
}

public class Count_Pairs_With_Given_Sum {

	public static void main(String[] args) {
		int sum = 6;
		int arr[] = new int[] { 1, 5, 7, -1, 5 };
		Count_Pairs_With_Given_SumSol sol = new Count_Pairs_With_Given_SumSol();
		System.out.println("Count of Sum pairs is " + sol.getPairsCountByHash(sum, arr));

		Count_Pairs_With_Given_DiffSol p = new Count_Pairs_With_Given_DiffSol();
		int arr2[] = { 1, 5, 2, 2, 2, 5, 5, 4 };
		int k = 3;
		System.out.println("Count of Diff pairs is " + p.getPairsCountByHash(k, arr2));

	}
}
