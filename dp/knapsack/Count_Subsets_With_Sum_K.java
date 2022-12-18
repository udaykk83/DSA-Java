package dp.knapsack;

public class Count_Subsets_With_Sum_K {

	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		int n = set.length;
		int ans = isSumPossibleByGivenSet(set, sum, n);
		System.out.println(ans);
	}

	private static int isSumPossibleByGivenSet(int[] nums, int sum, int n) {
		int dp[][] = new int[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else if (i == 0 && j > 0) {
					dp[i][j] = 0;
				} else if (nums[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		for (int[] r : dp) {
			for (int k : r) {
				System.out.print(k);
			}
			System.out.println();
		}
		return dp[n][sum];

	}

}
