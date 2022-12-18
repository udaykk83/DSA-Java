package heaps;

import java.util.*;

public class Min_Cost_to_Cut_Ropes {

	public static void main(String[] args) {
		List<Integer> prices = Arrays.asList(3, 4, 2, 6);
		PriorityQueue<Integer> pq = new PriorityQueue<>(prices);

		if (prices.size() < 2) {
			System.out.println(-1);
		}
		int sum = 0;

		while (pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			sum = sum + (a + b);
			pq.add(a + b);
		}
		System.out.println(sum);

	}

}
