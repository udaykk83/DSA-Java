package dp.knapsack;

public class Target_Sum {
	public static void main(String[] args) {
		int nums[] = { 1, 1, 1, 1, 1 };// [100]; //[0,0,0,0,0,0,0,0,1]; //
		int target = 9;// -200; //1;
		int n = nums.length;
		int ans = isTargetSumPossible(nums, target);
		System.out.println(ans);
	}

	private static int isTargetSumPossible(int[] nums, int target) {
		int n = nums.length;

		int sum = 0;
		for (int val : nums)
			sum += val;

		if (sum < target || -sum > target) {
			return 0;
		}

		// as we can't find out if k is fraction
		if ((target + sum) % 2 != 0) {
			return 0;
		}

		int k = (target + sum) / 2;
		// System.out.println(k);
		return countSubsetsWithSumEquals(nums, n, k);
	}

	public static int countSubsetsWithSumEquals(int[] nums, int n, int k) {
		int dp[][] = new int[n + 1][k + 1];
		dp[0][0] = 1;

		// if we have 0 in the set, then the sum = 0, would be in 2 ways,
		// by picing or by not picking it
		for (int i = 1; i < n + 1; i++) {
			if (nums[i - 1] == 0)
				dp[i][0] = dp[i - 1][0] * 2;
			else
				dp[i][0] = dp[i - 1][0];
		}

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < k + 1; j++) {
				if (j == 0) {
					continue;
				} else if (i == 0 && j > 0) {
					dp[i][j] = 0;
				} else if (nums[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][k];
	}

}
