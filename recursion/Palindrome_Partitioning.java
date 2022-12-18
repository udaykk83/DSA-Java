package recursion;

import java.util.*;

public class Palindrome_Partitioning {
	public static List<List<String>> partition(String str) {
		List<List<String>> ans = new ArrayList<List<String>>();
		int pos = 0;
		int n = str.length();
		List<String> part = new ArrayList<>();
		getAllPalidromeSubStrings(pos, n, str, part, ans);
		return ans;
	}

	public static void getAllPalidromeSubStrings(int pos, int n, String str, List<String> part,
			List<List<String>> ans) {
		if (pos == n) {
			List<String> temp = new ArrayList<>(part);
			ans.add(temp);
			return;
		}
		for (int i = pos; i < n; i++) {
			if (isPalindrome(pos, i, str)) {
				part.add(str.substring(pos, i + 1));
				getAllPalidromeSubStrings(i + 1, n, str, part, ans);
				part.remove(part.size() - 1);
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

	public static void main(String[] args) {
		System.out.println(partition("aaa"));
	}

}
