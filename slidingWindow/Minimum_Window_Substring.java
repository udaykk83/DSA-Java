package slidingWindow;

import java.util.*;

//Find the smallest window in a string containing all characters of another string
public class Minimum_Window_Substring {

	public static void main(String[] args) {
		char[] ch = "geeksforgeeks".toCharArray();
		char[] pat = "ork".toCharArray();

		Map<Character, Integer> hash = new HashMap<>();

		for (int i = 0; i < pat.length; i++) {
			int val = hash.getOrDefault(pat[i], 0) + 1;
			hash.put(pat[i], val);
		}
		int count = hash.size();

		int n = ch.length;
		int i = 0, j = 0;
		int ans = Integer.MAX_VALUE;

		while (j < n) {
			if (hash.containsKey(ch[j])) {
				int val = hash.get(ch[j]) - 1;
				hash.put(ch[j], val);
				if (val == 0) {
					count--;
				}
			}
			if (count > 0) {
				j++;
			} else if (count == 0) {

				while (count == 0) {
					ans = Math.min(ans, j - i + 1);
					if (hash.containsKey(ch[i])) {
						int k = 1 + hash.get(ch[i]);
						hash.put(ch[i], k);
						if (hash.get(ch[i]) >= 1) {
							count++;
						}
					}
					i++;
				}
				j++;
			}

		}
		System.out.println(ans);
	}

}
