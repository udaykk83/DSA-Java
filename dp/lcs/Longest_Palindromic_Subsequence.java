package dp.lcs;

public class Longest_Palindromic_Subsequence {

	public static void main(String[] args) {
		String s = "abac";
		System.out.println(longestPalindromeSubseq(s));

	}

	public static int longestPalindromeSubseq(String s) {
		char ch1[] = s.toCharArray();
		String t = new StringBuilder(s).reverse().toString();
		char ch2[] = t.toCharArray();

		int l1 = ch1.length;
		int l2 = ch2.length;

		int dp[][] = new int[l1 + 1][l2 + 1];
		for (int i = 0; i < l1 + 1; i++) {
			for (int j = 0; j < l2 + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (ch1[i - 1] == ch2[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[l1][l2];
	}
}
