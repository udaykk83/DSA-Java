package arrays;

import java.util.*;

class N_Light_Bulbs_Count_Minimum_Right_FlipsSol {

	public int findMinFlips(int[] arr) {
		int n = arr.length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (ans % 2 == 0) {
				// if flips is even, then no change in state, so 1 is correct
				if (arr[i] == 1)
					continue;
				// or else we increment count
				else
					ans++;
			} else {
				if (arr[i] == 1)
					ans++;
				else
					continue;
			}

		}

		return ans;
	}

}

public class N_Light_Bulbs_Count_Minimum_Right_Flips {

	public static void main(String[] args) {
		N_Light_Bulbs_Count_Minimum_Right_FlipsSol sol = new N_Light_Bulbs_Count_Minimum_Right_FlipsSol();
		int arr[] = new int[] { 1, 0, 0, 1, 0, 1 };
		int ans = sol.findMinFlips(arr);
		System.out.println(ans);

	}

}
