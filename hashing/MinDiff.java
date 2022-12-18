package hashing;

import java.util.*;

public class MinDiff {

	static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public static void main(String[] args) {

		int[] nums = { 9, 7, 2, 5, 3, 1 };
		int target = 10;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				System.out.println(nums[map.get(target - nums[i])] + " " + nums[i]);
				break;
			}
			map.put(nums[i], i);
		}

		int[] arr = { 2, 1, 4, 2, 6, 1, 4, 2, 3, 2, 4, 3 };
		HashMap<Integer, Integer> hash = new HashMap<>();
		int ans = Integer.MAX_VALUE;
		int a = -1, b = -1;
		for (int i = 0; i < arr.length; i++) {
			if (hash.containsKey(arr[i])) {
				if (ans > Math.abs(hash.get(arr[i]) - i)) {
					ans = Math.abs(hash.get(arr[i]) - i);
					a = hash.get(arr[i]);
					b = i;
				}
			}
			hash.put(arr[i], i);
		}
		System.out.println(a + " " + b);
	}
}
