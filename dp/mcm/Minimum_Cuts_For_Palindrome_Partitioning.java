package dp.mcm;

import java.util.*;

public class Minimum_Cuts_For_Palindrome_Partitioning {

	static int ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aab";
		System.out.println(minCut(str));
		System.out.println(byMCMMethod(str));
	}

	private static int byMCMMethod(String str) {
		int n = str.length();
		int dp[][] = new int[n + 1][n + 1];
		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}
		char ch[] = str.toCharArray();
		return countMinCutsMCMUtil(ch, 0, n - 1, dp);

	}

	private static int countMinCutsMCMUtil(char[] ch, int i, int j, int[][] dp) {
		if (i >= j) {
			return 0;
		}

		if (isPalindrome(i, j, new String(ch))) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int ans = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int temp = 1 + countMinCutsMCMUtil(ch, i, k, dp) + countMinCutsMCMUtil(ch, k + 1, j, dp);
			ans = Math.min(ans, temp);
			dp[i][j] = ans;
		}

		return dp[i][j];

	}

	public static int minCut(String str) {
		ans = Integer.MAX_VALUE;
		int pos = 0;
		int n = str.length();
		List<String> part = new ArrayList<>();
		int cnt = 0;
		getAllPalidromeSubStrings(pos, n, str, part, cnt);
		return ans;
	}

	public static void getAllPalidromeSubStrings(int pos, int n, String str, List<String> part, int cnt) {
		if (pos == n) {
			List<String> temp = new ArrayList<>(part);
			ans = Math.min(ans, cnt - 1);
			return;
		}
		for (int i = pos; i < n; i++) {
			if (isPalindrome(pos, i, str)) {
				// part.add(str.substring(pos,i+1));
				getAllPalidromeSubStrings(i + 1, n, str, part, cnt + 1);
				// part.remove(part.size()-1);
			}
		}
	}

	public static boolean isPalindrome(int l, int r, String str) {
		while (l < r) {
			if (str.charAt(l) != str.charAt(r)) {
				return false;
			} else {
				l++;
				r--;
			}
		}
		return true;
	}

}
