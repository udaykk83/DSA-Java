package heaps;

import java.util.*;

public class Heap_Basic_Implementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> li = Arrays.asList(1, 2, 3);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		int i = 0;
		while (i < li.size()) {
			pq.add(li.get(i));
			i++;
		}
		while (pq.size() > 0) {
			System.out.println(pq.peek());
			pq.poll();
		}
	}

}
