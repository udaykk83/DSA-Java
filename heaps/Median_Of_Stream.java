package heaps;

import java.util.*;

public class Median_Of_Stream {

	public static void main(String[] args) {
		PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
		PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());

		List<Integer> li = Arrays.asList(5, 15, 10, 20, 3);
		List<Double> ans = new ArrayList<>();

		int i = 0;
		while (i < li.size()) {
			int val = li.get(i);
			// if val < left max heap, then insert into it
			if (leftMaxHeap.size() == 0 || val < leftMaxHeap.peek()) {
				leftMaxHeap.add(val);
			} else {
				rightMinHeap.add(val);
			}

			// To rebalance the both heaps, if any has difference >= 2 like {1} {2,6,8},
			// then rebalance

			if (leftMaxHeap.size() + 1 < rightMinHeap.size()) {
				// right heap has many, so poll right heap
				int temp = rightMinHeap.poll();
				leftMaxHeap.add(temp);

			} else if (leftMaxHeap.size() > 1 + rightMinHeap.size()) {
				int temp = leftMaxHeap.poll();
				rightMinHeap.add(temp);
			}

			// storing the answer
			double med;
			if (leftMaxHeap.size() > rightMinHeap.size()) {
				med = leftMaxHeap.peek();
			} else if (leftMaxHeap.size() < rightMinHeap.size()) {
				med = rightMinHeap.peek();
			} else {
				med = leftMaxHeap.peek() + rightMinHeap.peek();
				med = med / 2;
			}
			ans.add(med);
			i++;
		}
		System.out.println(ans);
	}

}
