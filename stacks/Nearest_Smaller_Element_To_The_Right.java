package stacks;

import java.util.*;

public class Nearest_Smaller_Element_To_The_Right {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 2, 10, 8, 2, 9, 10 };
		System.out.println(" Array "+Arrays.toString(arr));
		findNearestSmallerELementsToTheRight(arr);
		findNearestLargerELementsToTheLeft(arr);
	}

	private static void findNearestLargerELementsToTheLeft(int[] arr) {
		int n = arr.length;
		Stack<Integer> currMaxStack = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			while (!currMaxStack.empty() && currMaxStack.peek() <= arr[i]) {
				currMaxStack.pop();
			}
			if (currMaxStack.empty()) {
				ans.add(-1);
			} else {
				ans.add(currMaxStack.peek());
			}
			currMaxStack.push(arr[i]);
		}
		System.out.println(" NLEOL " + ans);
		return;
	}

	// FOr finding largest/smaller from right, ans should be reversed
	private static void findNearestSmallerELementsToTheRight(int[] arr) {
		int n = arr.length;
		Stack<Integer> currMinStack = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = n - 1; i >= 0; i--) {
			// If min stack has elements greater than current iterating element,
			// then pop them out, as no longer minimum
			while (!currMinStack.empty() && currMinStack.peek() >= arr[i]) {
				currMinStack.pop();
			}
			if (currMinStack.empty()) {
				ans.add(-1);
			} else {
				ans.add(currMinStack.peek());
			}
			// Pushing curr element into stack, to consider for next element
			currMinStack.push(arr[i]);
		}

		for (int i = 0; i < n / 2; i++) {
			int temp = ans.get(i);
			ans.set(i, ans.get(n - i - 1));
			ans.set(n - i - 1, temp);
		}
		// Collections.reverse(ans);
		System.out.println(" NSEOR " + ans);
		return;
	}

}
