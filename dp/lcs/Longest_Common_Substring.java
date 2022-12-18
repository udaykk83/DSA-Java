package dp.lcs;

public class Longest_Common_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S1 = "ABCDGH", S2 = "ACDGHR";
		int n = 6, m = 6;
		System.out.println(longestCommonSubstrUsingDp(S1, S2, n, m));
		char ch1[] = S1.toCharArray();
		char ch2[] = S2.toCharArray();
		System.out.println(longestCommonSubstrUsingRecursion(ch1, ch2, n, m, 0));

	}

	private static int longestCommonSubstrUsingRecursion(char ch1[], char ch2[], int n, int m, int cnt) {
		// TODO Auto-generated method stub
		if (n == 0 || m == 0) {
			return cnt;
		}
		if (ch1[n - 1] == ch2[m - 1]) {
			cnt = longestCommonSubstrUsingRecursion(ch1, ch2, n - 1, m - 1, cnt + 1);
		}
		int b = Math.max(longestCommonSubstrUsingRecursion(ch1, ch2, n, m - 1, 0),
				longestCommonSubstrUsingRecursion(ch1, ch2, n - 1, m, 0));
		return Math.max(cnt, b);
	}

	private static int longestCommonSubstrUsingDp(String S1, String S2, int n, int m) {
		char ch1[] = S1.toCharArray();
		char ch2[] = S2.toCharArray();

		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (ch1[i - 1] == ch2[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					// reset the dp count
					dp[i][j] = 0;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				ans = Math.max(ans, dp[i][j]);
			}
		}
		return ans;
	}

}
