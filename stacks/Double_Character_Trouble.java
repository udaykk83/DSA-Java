package stacks;

import java.util.*;

public class Double_Character_Trouble {

	public static void main(String[] args) {
		String str = "azzxzy";
		findByRemovingAdjacentDuplicates(str);
	}

	private static void findByRemovingAdjacentDuplicates(String str) {
		Stack<Character> st = new Stack<>();
		char arr[] = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			// If stack is empty , push any
			if (st.empty()) {
				st.push(arr[i]);
			} else {
				// if same element found, then pop existing and don't insert
				if (st.peek() == arr[i]) {
					st.pop();
				} else {
					st.push(arr[i]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!st.empty()) {
			sb = sb.append(st.pop());
		}
		sb.reverse();
		System.out.println(sb.toString());
	}
}
