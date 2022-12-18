package dp.knapsack;

public class Unbounded_Knapsack {

	public static void main(String[] args) {
		int W = 3;
		int val[] = { 1, 1 };
		int wt[] = { 2, 1 };// 5, 10, 15 };
		int n = val.length;
		System.out.println(unboundedKnapsack(n, W, val, wt));
		System.out.println(unboundedKnapsackByDP(n, W, val, wt));
	}

	private static int unboundedKnapsackByDP(int n, int w, int[] val, int[] wt) {
		int dp[][] = new int[n + 1][w + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < w + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (wt[i - 1] <= j) {
					int include = val[i - 1] + dp[i][j - wt[i - 1]];
					int exclude = dp[i - 1][j];
					dp[i][j] = Math.max(include, exclude);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][w];
	}

	static int unboundedKnapsack(int N, int W, int val[], int wt[]) {
		if (N == 0 || W == 0) {
			return 0;
		}
		if (wt[N - 1] <= W) {
			int include = val[N - 1] + unboundedKnapsack(N, W - wt[N - 1], val, wt);
			int exclude = unboundedKnapsack(N - 1, W, val, wt);
			return Math.max(include, exclude);
		} else {
			return unboundedKnapsack(N - 1, W, val, wt);
		}
	}

}
