package slidingWindow;

import java.util.*;

//can have repeating characters
public class Smallest_Window_Contains_All_Chars_Of_String_Itself {

	public static void main(String[] args) {
		char[] ch = "aabcbcdbbca".toCharArray();
		int n = ch.length;

		Set<Character> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(ch[i]);
		}
		int k = set.size();

		Map<Character, Integer> hash = new HashMap<>();

		int i = 0, j = 0, ans = Integer.MAX_VALUE;

		while (j < n) {
			int val = hash.getOrDefault(ch[j], 0) + 1;
			hash.put(ch[j], val);

			if (hash.size() < k) {
				j++;
			} else if (hash.size() == k) {

				while (hash.size() == k) {
					ans = Math.min(ans, j - i + 1);
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
