package dp.stocks;

import java.util.*;

public class II_Buy_And_Sell_Stock_With_Cooldown {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int n = prices.length;
		int dp[][] = new int[n + 1][2];
		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(getMaxProfit(prices, 0, 1, dp));
		System.out.println(getMaxProfitByTopDown(prices, dp));
	}

	public static int getMaxProfitByTopDown(int[] prices, int dp[][]) {
		int n = prices.length;
		for (int row[] : dp) {
			Arrays.fill(row, 0);
		}
		dp[n][0] = 0;
		dp[n][1] = 0;

		for (int idx = n - 1; idx >= 0; idx--) {
			for (int j = 0; j <= 1; j++) {
				int profitSoFar = 0;
				if (j == 1) {
					int buyNow = -prices[idx] + dp[idx + 1][0];
					int buyLater = dp[idx + 1][1];
					profitSoFar = Math.max(buyNow, buyLater);
				} else {
					int sellNow = +prices[idx] + dp[idx + 1][1];
					int sellLater = dp[idx + 1][0];
					profitSoFar = Math.max(sellNow, sellLater);
				}
				dp[idx][j] = profitSoFar;
			}

		}
		return dp[0][1];
	}

	public static int getMaxProfit(int[] prices, int idx, int tobuy, int dp[][]) {
		if (idx == prices.length) {
			return 0;
		}

		if (dp[idx][tobuy] != -1) {
			return dp[idx][tobuy];
		}

		int profitSoFar = 0;
		if (tobuy == 1) {
			int buyNow = -prices[idx] + getMaxProfit(prices, idx + 1, 0, dp);
			int buyLater = getMaxProfit(prices, idx + 1, 1, dp);
			profitSoFar = Math.max(buyNow, buyLater);
		} else {
			int sellNow = +prices[idx] + getMaxProfit(prices, idx + 1, 1, dp);
			int sellLater = getMaxProfit(prices, idx + 1, 0, dp);
			profitSoFar = Math.max(sellNow, sellLater);
		}
		return dp[idx][tobuy] = profitSoFar;
	}

}
