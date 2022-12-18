package dp;

import java.util.*;

public class Word_Break {

	public static void main(String[] args) {
		String str = "leetcode";
		List<String> dict = Arrays.asList("cats", "dog", "sand", "and", "cat","leet","code");
		boolean ans = isPossibleToSegement(str, dict);
		System.out.println(ans);

	}

	private static boolean isPossibleToSegement(String str, List<String> dict) {
		int len = str.length();
		boolean dp[] = new boolean[len + 1];

		dp[0] = true;
		// i <= len, bcoz we are using as subString
		for (int i = 0; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] == true && dict.contains(str.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[len];
	}

}
