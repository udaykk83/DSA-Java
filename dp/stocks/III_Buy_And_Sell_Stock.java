package dp.stocks;

public class III_Buy_And_Sell_Stock {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int n = prices.length;
		int limit = 2;
		int dp[][][] = new int[n + 1][2][limit + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				for (int k = 0; k < dp[0][0].length; k++) {
					dp[i][j][k] = -1;
				}
			}
		}

		System.out.println(getMaxProfit(prices, 0, n, 1, limit, dp));
		System.out.println(getMaxprofitByTopDown(prices, n, limit, dp));
	}

	public static int getMaxprofitByTopDown(int[] prices, int n, int limit, int dp[][][]) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				for (int k = 0; k < dp[0][0].length; k++) {
					dp[i][j][k] = 0;
				}
			}
		}
		for (int idx = n - 1; idx >= 0; idx--) {
			for (int j = 0; j <= 1; j++) {
				for (int cnt = 1; cnt <= limit; cnt++) {
					int profitSoFar = 0;
					if (j == 1) {
						int buyNow = -prices[idx] + dp[idx + 1][0][cnt];
						int buyLater = dp[idx + 1][1][cnt];
						profitSoFar = Math.max(buyNow, buyLater);
					} else {
						int sellNow = +prices[idx] + dp[idx + 1][1][cnt - 1];
						int sellLater = dp[idx + 1][0][cnt];
						profitSoFar = Math.max(sellNow, sellLater);
					}
					dp[idx][j][cnt] = profitSoFar;
				}
			}
		}
		return dp[0][1][limit];
	}

	public static int getMaxProfit(int[] prices, int idx, int n, int toBuy, int limit, int dp[][][]) {
		if (idx == n) {
			return 0;
		}
		if (limit == 0) {
			return 0;
		}

		if (dp[idx][toBuy][limit] != -1) {
			return dp[idx][toBuy][limit];
		}

		int profitSoFar = 0;
		if (toBuy == 1) {
			int buyNow = -prices[idx] + getMaxProfit(prices, idx + 1, n, 0, limit, dp);
			int buyLater = getMaxProfit(prices, idx + 1, n, 1, limit, dp);
			profitSoFar = Math.max(buyNow, buyLater);
		} else {
			int sellNow = +prices[idx] + getMaxProfit(prices, idx + 1, n, 1, limit - 1, dp);
			int sellLater = getMaxProfit(prices, idx + 1, n, 0, limit, dp);
			profitSoFar = Math.max(sellNow, sellLater);
		}
		return dp[idx][toBuy][limit] = profitSoFar;
	}

}
