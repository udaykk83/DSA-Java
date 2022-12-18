package dp.knapsack;

public class Rod_Cutting {

	public static void main(String[] args) {
		int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int n = price.length;
		int ans = getMaxProfitByCuttingRod(price, n);
		System.out.println(ans);
		int len[] = new int[n];
		for (int i = 0; i < n; i++) {
			len[i] = i + 1;
		}

	}

	private static int getMaxProfitByCuttingRod(int[] price, int n) {
		int dp[][] = new int[n + 1][n + 1];

		// the selected rod length item
		for (int i = 0; i < n + 1; i++) {
			// the max length of the rod, for which profit is being maximized
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
					// i <= j because, len[i-1] == i , at 0th index we have 1 len
				} else if (i <= j) {
					int include = price[i - 1] + dp[i][j - (i)];
					int exclude = dp[i - 1][j];
					dp[i][j] = Math.max(include, exclude);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][n];
	}

}
