package dp.mcm;

import java.util.*;

public class Minimum_Cost_To_Cut_A_Stick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 3, 1, 5, 8 };
		System.out.println(minCost(7, nums));
	}

	public static int minCost(int n, int[] cuts) {
		List<Integer> li = new ArrayList<>();
		li.add(0);
		for (int a : cuts) {
			li.add(a);
		}
		li.add(n);
		int dp[][] = new int[li.size() + 3][li.size() + 3];
		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}
		Collections.sort(li);
		return getMinCostByMCM(li, 1, cuts.length, dp);
	}

	private static int getMinCostByMCM(List<Integer> li, int i, int j, int[][] dp) {
		if (i > j) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int ans = Integer.MAX_VALUE;

		for (int k = i; k <= j; k++) {
			int temp = getMinCostByMCM(li, i, k - 1, dp) + getMinCostByMCM(li, k + 1, j, dp)
					+ (li.get(j + 1) - li.get(i - 1));
			dp[i][j] = ans = Math.min(ans, temp);

		}
		return dp[i][j];
	}

}
