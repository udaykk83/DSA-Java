package dp.knapsack;

public class Coin_Change_Min_No_Of_Coins {

	public static void main(String[] args) {
		int amount = 11;
		int coins[] = { 1, 2, 5 };
		System.out.println(coinChange(coins, amount));

	}

	public static int coinChange(int[] coins, int amt) {
		int n = coins.length;
		int dp[][] = new int[n + 1][amt + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < amt + 1; j++) {
				if (i == 0 || j == 0) {
					if (i == 0) {
						dp[i][j] = Integer.MAX_VALUE - 1;
					} else {
						dp[i][j] = 0;
					}
				} else if (i == 1) {
					if (j % coins[i - 1] == 0) {
						dp[i][j] = j / coins[i - 1];
					} else {
						dp[i][j] = Integer.MAX_VALUE - 1;
					}
				} else if (coins[i - 1] <= j) {
					int incl = 1 + dp[i][j - coins[i - 1]];
					int excl = dp[i - 1][j];
					dp[i][j] = Math.min(incl, excl);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][amt] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amt];
	}

}
