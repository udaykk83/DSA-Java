package slidingWindow;

import java.util.*;

public class First_Negative_Integer_In_Every_Window_Of_Size_K {

	public static void main(String[] args) {
		int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 }, k = 3;
		int n = arr.length;

		List<Integer> ans = new ArrayList<>();
		int i = 0;
		int j = 0;
		Queue<Integer> q = new LinkedList<>();

		while (j < n) {
			if (arr[j] < 0) {
				q.add(arr[j]);
			}
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (q.isEmpty()) {
					ans.add(-1);
				} else {
					ans.add(q.peek());
					if (q.peek() == arr[i]) {
						q.poll();
					}
				}
				i++;
				j++;
			}

		}
		System.out.println(ans);

	}

}
