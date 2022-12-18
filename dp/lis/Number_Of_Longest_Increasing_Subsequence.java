package dp.lis;

import java.util.*;

public class Number_Of_Longest_Increasing_Subsequence {

	public static void main(String[] args) {
		int nums[] = new int[] {1,2,4,3,5,4,7,2};
		System.out.println(findNumberOfLIS(nums));

	}

	public static int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		int lis[] = new int[n];
		int cnt[] = new int[n];

		int ans = 0;
		int len = 0;

		if (n == 0) {
			return ans;
		}

		lis[0] = 1;
		cnt[0] = 1;
		len = 1;

		Arrays.fill(cnt, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					// for new lis
					if (lis[i] < lis[j]) {
						lis[i] = lis[j];
						// cnt as same as existing prev
						cnt[i] = cnt[j];
					} else if (lis[i] == lis[j]) {
						// we already found lis combination
						// so incrementing on that count
						System.out.println("hi"+ i);
						cnt[i] = cnt[i] + cnt[j];
					}
				}
			}
			lis[i]++;
			// to keep track of the max lis length, to find cnt of that
			// lis length
			len = Math.max(len, lis[i]);
		}
		System.out.println(Arrays.toString(nums));

		System.out.println(Arrays.toString(lis));
		System.out.println(Arrays.toString(cnt));

		for (int i = 0; i < n; i++) {
			if (len == lis[i]) {
				ans = ans + cnt[i];
			}
		}
		return ans;
	}

}
