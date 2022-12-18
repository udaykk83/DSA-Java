package arrays;

import java.util.*;

class Find_Minimum_Sum_Subarray_Of_Size_KSol {
	public int find_Minimum_Sum_Subarray_Of_Size_KSol(int[] arr, int k) {
		int ans = Integer.MAX_VALUE;
		int n = arr.length;
		int pre[] = new int[n + 2];

		for (int i = 0; i < n; i++) {
			pre[i + 1] = pre[i] + arr[i];
		}
		System.out.println(Arrays.toString(pre));
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = k; i < n; i++) {
			int currSum = pre[i] - pre[i - k];
			if (ans > currSum) {
				ans = currSum;
				list.clear();
				list.add(i);
				list.add(i - k + 1);
			}
		}

		System.out.println(list);
		return ans;
	}
}

public class Find_Minimum_Sum_Subarray_Of_Size_K {

	public static void main(String[] args) {
		int arr[] = new int[] { 10, 4, 2, 5, 6, 3, 8, 1 };
		int k = 3;
		Find_Minimum_Sum_Subarray_Of_Size_KSol p = new Find_Minimum_Sum_Subarray_Of_Size_KSol();
		int ans = p.find_Minimum_Sum_Subarray_Of_Size_KSol(arr, k);
		System.out.println(ans);
	}

}
