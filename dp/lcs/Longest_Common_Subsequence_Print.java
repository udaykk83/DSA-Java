package dp.lcs;

public class Longest_Common_Subsequence_Print {

	public static void main(String[] args) {
		String text1 = "bbbaaaba", text2 = "bbababbb";
		System.out.println(longestCommonSubsequence(text1, text2));
	}

	private static String longestCommonSubsequence(String text1, String text2) {
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

		int r = l1, c = l2;
		String ans = "";
		while (r > 0 && c > 0) {
			if (ch1[r - 1] == ch2[c - 1]) {
				ans = ans + ch1[r - 1];
				r--;
				c--;
			} else {
				if (lcs[r - 1][c] > lcs[r][c - 1]) {
					r--;
				} else {
					c--;
				}
			}
		}
		String str = new StringBuffer(ans).reverse().toString();
		System.out.println(l1+l2-str.length());
		return str;
	}

}
