package heaps;

import java.util.*;

//TC o(NlogK)
public class Product_Of_3 {

	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(10, 2, 13, 4);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		List<Integer> ans = new ArrayList<>();
		int k = 3;

		int i = 0;
		int product = 1;
		while (i < li.size()) {
			if (pq.size() < k) {// 3
				pq.add(li.get(i));
				product = product * li.get(i);
			} else {
				int val = li.get(i);
				if (val > pq.peek()) {
					int min = pq.poll();
					pq.add(val);
					product = product * val;
					product = product / min;
				}
			}

			if (i < k - 1) {// 2
				ans.add(-1);
			} else {
				ans.add(product);
			}

			i++;
		}
		System.out.println(ans);
	}

}
