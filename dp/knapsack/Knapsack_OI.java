package dp.knapsack;

import java.util.*;

public class Knapsack_OI {

	public static void main(String[] args) {
		int[] values = { 20, 5, 10, 40, 15, 25 };
		int[] weights = { 1, 2, 3, 8, 7, 4 };
		// knapsack capacity
		int W = 10;
		int n = values.length;// or weights.length
		System.out.println(getMaximumPriceByRecursion(values, weights, W, n));
		int rdp[][] = new int[n + 1][W + 1];

		for (int[] r : rdp) {
			Arrays.fill(r, -1);
		}
		System.out.println(solveByMemoization(W, weights, values, n, rdp));
		int dp[][] = new int[n + 1][W + 1];

		// i represents the item which is being selected
		for (int i = 0; i < n + 1; i++) {
			// j represents the bag Capacity --> W
			for (int j = 0; j < W + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (weights[i - 1] <= j) {
					int include = values[i - 1] + dp[i - 1][j - weights[i - 1]];
					int exclude = dp[i - 1][j];
					dp[i][j] = Math.max(include, exclude);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][W]);
	}

	private static int getMaximumPriceByRecursion(int[] val, int[] wts, int w, int size) {
		if (size == 0 || w == 0) {
			return 0;
		}

		if (wts[size - 1] <= w) {
			int include = val[size - 1] + getMaximumPriceByRecursion(val, wts, w - wts[size - 1], size - 1);
			int exclude = getMaximumPriceByRecursion(val, wts, w, size - 1);
			return Math.max(include, exclude);
		} else {
			return getMaximumPriceByRecursion(val, wts, w, size - 1);
		}
	}

	private static int solveByMemoization(int W, int wt[], int val[], int n, int rdp[][]) {
		if (n == 0 || W == 0) {
			return 0;
		}
		if (rdp[n][W] != -1) {
			return rdp[n][W];
		}
		// check if weight is eligible to place in bag
		if (wt[n - 1] <= W) {
			int include = val[n - 1] + solveByMemoization(W - wt[n - 1], wt, val, n - 1, rdp);
			int exclude = solveByMemoization(W, wt, val, n - 1, rdp);
			return rdp[n][W] = Math.max(include, exclude);
		} else {
			return rdp[n][W] = solveByMemoization(W, wt, val, n - 1, rdp);
		}
	}

}
