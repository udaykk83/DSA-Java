package slidingWindow;

import java.util.*;

public class Longest_Substring_With_Without_Repeating_Characters {

	public static void main(String[] args) {
		char[] ch = "ABDEFGABEF".toCharArray();
		int n = ch.length;
		int i = 0, j = 0;
		int ans = 0;
		Map<Character, Integer> hash = new HashMap<>();
		while (j < n) {
			int val = 1 + hash.getOrDefault(ch[j], 0);
			hash.put(ch[j], val);
			if (hash.size() == j - i + 1) {
				ans = Math.max(ans, j - i + 1);
				j++;
			} else if (hash.size() < j - i + 1) {
				while (hash.size() < j - i + 1) {
					int temp = hash.get(ch[i]) - 1;
					hash.put(ch[i], temp);
					if (hash.get(ch[i]) == 0) {
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
