package recursion;

import java.util.*;

public class Sort_And_Reverse_A_Stack {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(5);
		st.push(3);
		st.push(8);
		st.push(6);
		st.push(1);
		System.out.println(st);
		sortAStack(st);
		System.out.print("sorted is ");
		System.out.println(st);
		reverseAStack(st);
		System.out.print("reversed is ");
		System.out.println(st);

	}

	private static void reverseAStack(Stack<Integer> st) {
		if (st.empty()) {
			return;
		}
		int val = st.pop();
		reverseAStack(st);
		insertAtTheStackBottom(st, val);
	}

	private static void insertAtTheStackBottom(Stack<Integer> st, int val) {
		if (st.empty()) {
			st.push(val);
			return;
		}
		int temp = st.pop();
		insertAtTheStackBottom(st, val);
		st.push(temp);
	}

	private static void sortAStack(Stack<Integer> st) {
		if (st.empty()) {
			return;
		}
		int val = st.pop();
		sortAStack(st);
		insertAccToValue(st, val);
	}

	private static void insertAccToValue(Stack<Integer> st, int val) {
		if (st.empty() || st.peek() <= val) {
			st.push(val);
			return;
		}
		int temp = st.pop();
		insertAccToValue(st, val);
		st.push(temp);
	}

}
