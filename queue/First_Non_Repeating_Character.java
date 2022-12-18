package queue;

import java.util.*;

public class First_Non_Repeating_Character {

	public static void main(String[] args) {
		String str = "aabcabcbcabcba";
		getfirstNonRepeating(str.toCharArray());
	}

	private static void getfirstNonRepeating(char[] ch) {
		int n = ch.length;
		Queue<Character> q = new LinkedList<>();
		HashMap<Character, Integer> map = new HashMap<>();

		ArrayList<Character> li = new ArrayList<>();
		String ans = "";

		for (int i = 0; i < n; i++) {
			q.add(ch[i]);

			map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);

			// check and remove chars if Frequency > 1
			while (!q.isEmpty() && map.get(q.peek()) > 1) {
				q.poll();
			}

			if (q.isEmpty()) {
				ans = ans + "-1";
				li.add('1');
			} else {
				ans = ans + q.peek();
				li.add(q.peek());
			}
		}
		System.out.println(li.toString());
		System.out.println(ans);

	}

}
