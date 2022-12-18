package dp.lcs;

public class Shortest_Common_Supersequence {

	public static void main(String[] args) {
		String str1 = "abac", str2 = "cab";
		System.out.println(shortestCommonSupersequence(str1, str2));

	}

	public static String shortestCommonSupersequence(String str1, String str2) {
		int l1 = str1.length();
		int l2 = str2.length();
		int lcs[][] = new int[l1 + 1][l2 + 1];
		char ch1[] = str1.toCharArray();
		char ch2[] = str2.toCharArray();
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

		int i = l1, j = l2;
		String ans = "";
		while (i > 0 && j > 0) {
			if (ch1[i - 1] == ch2[j - 1]) {
				ans = ans + ch1[i - 1];
				i--;
				j--;
			} else {
				if (lcs[i - 1][j] > lcs[i][j - 1]) {
					ans = ans + ch1[i - 1];
					i--;
				} else {
					ans = ans + ch2[j - 1];
					j--;
				}
			}
		}
		// System.out.println(i+" j is "+j);
		while (i > 0) {
			ans = ans + ch1[i - 1];
			i--;
		}
		while (j > 0) {
			ans = ans + ch2[j - 1];
			j--;
		}

		return new StringBuffer(ans).reverse().toString();
	}

}
