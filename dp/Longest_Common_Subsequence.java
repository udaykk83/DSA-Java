package dp;

public class Longest_Common_Subsequence {

	public static void main(String[] args) {
		String s1 = "abcde", s2 = "def";
		int l1 = s1.length();
		int l2 = s2.length();
		int k1 = getLCSByRecursion(s1, s2, l1, l2);
		int k2 = getLCSByDP(s1, s2, l1, l2);
		System.out.println(k1 + " and " + k2);
	}

	private static int getLCSByDP(String s1, String s2, int l1, int l2) {
		int lcs[][] = new int[l1 + 1][l2 + 1];
		char ch1[] = s1.toCharArray();
		char ch2[] = s2.toCharArray();
		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (ch1[i - 1] == ch2[j - 1]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}

		return lcs[l1][l2];
	}

	private static int getLCSByRecursion(String s1, String s2, int l1, int l2) {
		if (l1 == 0 || l2 == 0) {
			return 0;
		}
		if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
			return 1 + getLCSByRecursion(s1, s2, l1 - 1, l2 - 1);
		} else {
			return Math.max(getLCSByRecursion(s1, s2, l1 - 1, l2), getLCSByRecursion(s1, s2, l1, l2 - 1));
		}
	}

}
