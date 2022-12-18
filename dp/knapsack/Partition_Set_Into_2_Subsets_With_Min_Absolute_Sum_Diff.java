package dp.knapsack;

public class Partition_Set_Into_2_Subsets_With_Min_Absolute_Sum_Diff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1, 6, 11, 5 };
		int ans = getMinDiff(nums);
		System.out.println(ans);
	}

	private static int getMinDiff(int[] nums) {
		int n = nums.length;
		int sum = 0;
		for (int a : nums) {
			sum += a;
		}
		boolean dp[][] = new boolean[n + 1][sum + 1];
		int diff = Integer.MAX_VALUE;

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (j == 0) {
					dp[i][j] = true;
				} else if (i == 0 && j > 0) {
					dp[i][j] = false;
				} else if (nums[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

//		as totalSum = S1+S2;
//		if s1 exists, then s2 exists
//		range of totalSum is 0 to sum of all elements
//		so, if we iterate upto totalSum/2, then the other half can be subtracted from that
//		Our work is very simple, using the last row of the dp array, we will first find which 
//		all S1 values are valid. Using the valid S1 values, we will find S2 (totSum – S1). 
//		From this S1 and S2, we will find their absolute difference. 
//		We will return the minimum value of this absolute difference as our answer.

		// as all the values will be taken or not taken in the last row, so using that
		for (int k = 0; k <= sum / 2; k++) {
			if (dp[n][k] == true) {
				diff = Math.min(diff, Math.abs(sum - k - (k)));
			}
		}

		return diff;

	}

}
