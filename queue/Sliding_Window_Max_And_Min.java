package queue;

import java.util.*;

public class Sliding_Window_Max_And_Min {

	public static void main(String[] args) {
		int arr[] = { 1, 3, -1, -3, 5, 9, 6, 7 };
		int k = 3;
		System.out.println(Arrays.toString(arr));
		findSlidingWindowMax(arr, k);
		findSlidingWindowMinimum(arr, k);
	}

	// graph should look like increasing order
	private static void findSlidingWindowMinimum(int[] arr, int k) {
		Deque<Integer> dq = new LinkedList<>();

		int i = 0;
		int j = 0;
		int n = arr.length;

		ArrayList<Integer> ans = new ArrayList<>();

		while (j < n) {

			while (!dq.isEmpty() && arr[dq.peekLast()] > arr[j]) {
				dq.pollLast();
			}
			dq.addLast(j);

			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				ans.add(arr[dq.peekFirst()]);
				if (dq.peekFirst() == i) {
					dq.pollFirst();
				}
				i++;
				j++;
			}
		}
		System.out.println(ans);
	}

	// graph should look like decreasing order
	private static void findSlidingWindowMax(int[] arr, int k) {
		Deque<Integer> dq = new LinkedList<>();

		int i = 0;
		int j = 0;
		int n = arr.length;

		ArrayList<Integer> ans = new ArrayList<>();

		// store indices in deque, to compare elements
		while (j < n) {

			// if we get a larger element in iterating, remove values
			// that are less than that, as they would not be maximum
			while (!dq.isEmpty() && arr[dq.peekLast()] < arr[j]) {
				dq.pollLast();
			}

			dq.addLast(j);

			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				ans.add(arr[dq.peekFirst()]);
				if (dq.peekFirst() == i) {
					dq.pollFirst();
				}
				i++;
				j++;
			}
		}
		System.out.println(ans);
	}

}
