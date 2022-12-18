package dp.mcm;

import java.util.*;

public class Matrix_Chain_Multiplication {

	public static void main(String[] args) {
		int arr[] = { 40, 20, 30, 10, 30 };
		int n = arr.length;
		int dp[][] = new int[n + 1][n + 1];
		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(getMinMatrixOperations(arr, 1, n - 1, dp));

	}

	private static int getMinMatrixOperations(int[] arr, int i, int j, int[][] dp) {
		// i > j --> no matrix present to multiply
		// i == j --> only one element is present,so no need to multiply
		if (i >= j) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int ans = Integer.MAX_VALUE;

		for (int k = i; k <= j - 1; k++) {
			int tempAns = getMinMatrixOperations(arr, i, k, dp) + getMinMatrixOperations(arr, k + 1, j, dp)
					+ arr[i - 1] * arr[k] * arr[j];
			ans = Math.min(ans, tempAns);
			dp[i][j] = ans;

		}

		return dp[i][j];
	}

}
