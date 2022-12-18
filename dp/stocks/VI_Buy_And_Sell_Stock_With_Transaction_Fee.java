package dp.stocks;

import java.util.*;

public class VI_Buy_And_Sell_Stock_With_Transaction_Fee {

	public static void main(String[] args) {
		int fee = 2;
		int[] prices = { 1, 3, 2, 8, 4, 9 };
		int n = prices.length;
		int dp[][] = new int[n + 1][2];
		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(getMaxProfit(prices, 0, 1, dp, fee));
		System.out.println(getMaxProfitByTopDown(prices, dp, fee));
	}

	public static int getMaxProfitByTopDown(int[] prices, int dp[][], int fee) {
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
					int buyNow = -fee - prices[idx] + dp[idx + 1][0];
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

	public static int getMaxProfit(int[] prices, int idx, int tobuy, int dp[][], int fee) {
		if (idx == prices.length) {
			return 0;
		}

		if (dp[idx][tobuy] != -1) {
			return dp[idx][tobuy];
		}

		int profitSoFar = 0;
		if (tobuy == 1) {
			int buyNow = -fee - prices[idx] + getMaxProfit(prices, idx + 1, 0, dp, fee);
			int buyLater = getMaxProfit(prices, idx + 1, 1, dp, fee);
			profitSoFar = Math.max(buyNow, buyLater);
		} else {
			int sellNow = +prices[idx] + getMaxProfit(prices, idx + 1, 1, dp, fee);
			int sellLater = getMaxProfit(prices, idx + 1, 0, dp, fee);
			profitSoFar = Math.max(sellNow, sellLater);
		}
		return dp[idx][tobuy] = profitSoFar;
	}

}
