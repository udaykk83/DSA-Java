package hashing;

import java.util.*;

class Find_Subarrays_With_A_Given_SumSol {

	public ArrayList<ArrayList<Integer>> findSubarraysByHashmap(int[] arr, int k) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		int n = arr.length;
		HashMap<Integer, List<Integer>> hash = new HashMap<>();
		int currSum = 0;
		// If starting element is equal is given sum
		hash.put(0, new ArrayList<Integer>(List.of(-1)));

		for (int i = 0; i < n; i++) {
			currSum += arr[i];
			List<Integer> list = new ArrayList<>();
			if (hash.containsKey(currSum - k)) {
				list = hash.get(currSum - k);
				for (int j = 0; j < list.size(); j++) {
					ans.add(new ArrayList<Integer>(List.of(list.get(j) + 1, i)));
				}
			}
			list = hash.getOrDefault(currSum, new ArrayList<>());
			list.add(i);
			hash.put(currSum, list);
		}
		
		System.out.println(hash);
		System.out.println(ans);
		System.out.println();
		return ans;
	}

}

public class Find_Subarrays_With_A_Given_Sum {

	public static void main(String[] args) {
		Find_Subarrays_With_A_Given_SumSol sol = new Find_Subarrays_With_A_Given_SumSol();
		int arr[] = new int[] { 3, 4, -7, 1, 3, 3, 1, -4 };
		int k = 7;
		ArrayList<ArrayList<Integer>> ans = sol.findSubarraysByHashmap(arr, k);

		// int arr1[] = { 10, 2, -2, -20, 10 };
		int sum = k;// -10;
		int n = arr.length;
		System.out.println(findCountOfSubarraySums(arr, n, sum));
	}

	static int findCountOfSubarraySums(int arr[], int n, int sum) {
		HashMap<Integer, Integer> prevSum = new HashMap<>();
		prevSum.put(0, 1);
		int res = 0;
		int currSum = 0;

		for (int i = 0; i < n; i++) {
			currSum += arr[i];
			int removeSum = currSum - sum;
			if (prevSum.containsKey(removeSum)) {
				res += prevSum.get(removeSum);
			}
			prevSum.put(currSum, prevSum.getOrDefault(currSum, 0) + 1);
		}
		System.out.println(prevSum);
		return res;
	}
}
