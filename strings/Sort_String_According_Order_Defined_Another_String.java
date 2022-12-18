package strings;

import java.util.*;

class Sort_String_According_Order_Defined_Another_StringSol {

	public void sortByPattern(char[] string, char[] pattern) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < string.length; i++) {
			int k = map.getOrDefault(string[i], 0);
			k++;
			map.put(string[i], k);
		}
		System.out.println(map);

		int idx = 0;
		for (int i = 0; i < pattern.length; i++) {
			int k = map.getOrDefault(pattern[i], 0);
			for (int j = 0; j < k; j++) {
				string[idx] = pattern[i];
				idx++;
			}
		}
		System.out.println("String is " + String.valueOf(string));
	}

}
//Given two strings (of lowercase letters), a pattern, and a string.
//The task is to sort strings according to the order defined by the pattern. 
//It may be assumed that the pattern has all characters of the string 
//and all characters in the pattern appear only once.

public class Sort_String_According_Order_Defined_Another_String {

	public static void main(String[] args) {
		Sort_String_According_Order_Defined_Another_StringSol sol = new Sort_String_According_Order_Defined_Another_StringSol();
		char[] pattern = "bxyzca".toCharArray();
		char[] string = "abcabcabc".toCharArray();
		sol.sortByPattern(string, pattern);
	}

}
