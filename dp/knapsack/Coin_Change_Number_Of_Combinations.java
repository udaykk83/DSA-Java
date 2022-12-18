package dp.knapsack;

public class Coin_Change_Number_Of_Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int amount = 4;
		int coins[] = { 1, 2, 3 };
		System.out.println(noOfWaysTochange(amount, coins));
	}

	public static int noOfWaysTochange(int amount, int[] coins) {
		// same as unbounded knapsack and combination of count of no of ways of subset
		// sum
		int n = coins.length;
		int dp[][] = new int[n + 1][amount + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < amount + 1; j++) {
				if (i == 0) {
					dp[i][j] = 0;
				}
				if (j == 0) {
					dp[i][j] = 1;
				}
				if (i > 0 && j > 0) {
					if (coins[i - 1] <= j) {
						dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}
		return dp[n][amount];
	}

}
