package dp.lcs;

public class Longest_Common_Subsequence {

	public static void main(String[] args) {
		String text1 = "abcde", text2 = "ace";
		System.out.println(longestCommonSubsequence(text1, text2));
	}

	private static int longestCommonSubsequence(String text1, String text2) {
		int l1 = text1.length();
		int l2 = text2.length();
		int lcs[][] = new int[l1 + 1][l2 + 1];
		char ch1[] = text1.toCharArray();
		char ch2[] = text2.toCharArray();
		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (ch1[i - 1] == ch2[j - 1]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		return lcs[l1][l2];
	}

}
