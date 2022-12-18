package slidingWindow;

import java.util.*;

public class Count_Occurrences_Of_Anagrams {

	public static void main(String[] args) {
		char str[] = "forxxorfxdofr".toCharArray();
		int n = str.length;
		char pat[] = "for".toCharArray();
		int k = pat.length;

		int count = 0;
		Map<Character, Integer> hash = new HashMap<>();

		for (int i = 0; i < pat.length; i++) {
			if (hash.containsKey(pat[i])) {
				hash.put(pat[i], 1 + hash.get(pat[i]));
			} else {
				hash.put(pat[i], 1);
				count++;
			}
		}

		int i = 0, j = 0;
		int ans = 0;
		while (j < n) {
			if (hash.containsKey(str[j])) {
				hash.put(str[j], hash.get(str[j]) - 1);
				if (hash.get(str[j]) == 0) {
					count--;
				}
			}
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (count == 0) {
					ans++;
				}
				if (hash.containsKey(str[i])) {
					hash.put(str[i], 1 + hash.get(str[i]));
					if (hash.get(str[i]) == 1) {
						count++;
					}
				}
				i++;
				j++;
			}

		}
		System.out.println(ans);
	}

}
