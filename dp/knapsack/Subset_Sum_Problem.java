package dp.knapsack;

public class Subset_Sum_Problem {

	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		int n = set.length;
		boolean ans = isSumPossibleByGivenSet(set, sum, n);
		System.out.println(ans);
	}

	private static boolean isSumPossibleByGivenSet(int[] nums, int sum, int n) {
		boolean dp[][] = new boolean[n + 1][sum + 1];
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

		return dp[n][sum];
	}

}
