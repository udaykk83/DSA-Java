package stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Largest_Rectangle_In_A_Histogram {

	public static void main(String[] args) {
		int arr[] = { 6, 2, 5, 4, 5, 1, 6 };
		calculateMaxArea(arr);
	}

	// Store indices in left and right, to calculate width
	private static void calculateMaxArea(int[] arr) {
		int n = arr.length;
		int leftMin[] = findSmallerELelmentsOnLeft(arr, n);
		int rightMin[] = findSmallerELelmentsOnRight(arr, n);

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int width = rightMin[i] - leftMin[i] - 1;
			int area = width * arr[i];
			ans = Math.max(ans, area);
		}
		System.out.println(ans);
	}

	private static int[] convertToArray(ArrayList<Integer> list) {
		return list.stream().mapToInt(a -> a).toArray();
	}

	// if not found use n (array length)
	private static int[] findSmallerELelmentsOnRight(int[] arr, int n) {
		Stack<Integer> st = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!st.empty() && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			if (st.empty()) {
				ans.add(n);
			} else {
				ans.add(st.peek());
			}
			st.push(i);
		}
		Collections.reverse(ans);
		return convertToArray(ans);
	}

	// if not found use -1
	private static int[] findSmallerELelmentsOnLeft(int[] arr, int n) {
		Stack<Integer> st = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			while (!st.empty() && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			if (st.empty()) {
				ans.add(-1);
			} else {
				ans.add(st.peek());
			}
			st.push(i);
		}
		return convertToArray(ans);
	}

}
