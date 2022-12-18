package slidingWindow;

import java.util.*;

public class Longest_Substring_With_K_Unique_Characters {

	public static void main(String[] args) {
		char[] ch = "aabbcc".toCharArray();
		int k = 3;

		int ans = 0;
		int n = ch.length;
		int i = 0, j = 0;

		Map<Character, Integer> hash = new HashMap<>();

		while (j < n) {
			int val = 1 + hash.getOrDefault(ch[j], 0);
			hash.put(ch[j], val);
			if (hash.size() < k) {
				j++;
			} else if (hash.size() == k) {
				ans = Math.max(ans, j - i + 1);
				j++;
			} else {
				while (hash.size() > k) {
					int temp = hash.getOrDefault(ch[i], 0) - 1;
					hash.put(ch[i], temp);
					if (temp == 0) {
						hash.remove(ch[i]);
					}
					i++;
				}
				j++;
			}
		}
		System.out.println(ans);

	}

}
