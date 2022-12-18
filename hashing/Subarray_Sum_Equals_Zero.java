package hashing;

import java.util.*;

class Sol {

	public void checkIfExistsSubarrayWithSumZero(int[] arr) {
		int n = arr.length;
		HashSet<Integer> hash = new HashSet<>();
		int currSum = 0;
		for (int i = 0; i < n; i++) {
			currSum += arr[i];
			if (currSum == 0) {
				System.out.println("Exists");
				return;
			}
			if (hash.contains(currSum - 0)) {
				System.out.println("Exists");
				return;
			}
			hash.add(currSum);
		}
		System.out.println("NO");

	}

}

public class Subarray_Sum_Equals_Zero {

	public static void main(String[] args) {
		Sol s = new Sol();
		int[] arr = { 4, -6, 3, -1, 4, 2, 7 };
		s.checkIfExistsSubarrayWithSumZero(arr);
	}

}
