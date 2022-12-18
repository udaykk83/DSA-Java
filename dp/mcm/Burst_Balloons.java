package dp.mcm;

import java.util.*;

public class Burst_Balloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 3, 1, 5, 8 };
		System.out.println(maxCoins(nums));
	}

	public static int maxCoins(int[] nums) {
		List<Integer> li = new ArrayList<>();
		for (int a : nums) {
			li.add(a);
		}
		li.add(0, 1);
		li.add(1);
		int n = li.size();
		int dp[][] = new int[n + 10][n + 10];
		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}
		return getMaxCoinsByBursting(li, 1, n - 2, dp);
	}

	private static int getMaxCoinsByBursting(List<Integer> li, int i, int j, int[][] dp) {
		if (i > j) {
			return 0;
		}
		int ans = Integer.MIN_VALUE;
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		for (int k = i; k <= j; k++) {
			int temp = li.get(i - 1) * li.get(k) * li.get(j + 1) + getMaxCoinsByBursting(li, i, k - 1, dp)
					+ getMaxCoinsByBursting(li, k + 1, j, dp);
			ans = Math.max(ans, temp);
		}
		return dp[i][j] = ans;
	}

}
