package stacks;

import java.util.Stack;

public class Minimum_Element_From_The_Stack {
	private static Stack<Integer> ans = new Stack<>();

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		push(s, 3);
		push(s, 5);
		getMin(s);
		push(s, 2);
		push(s, 1);
		getMin(s);
		pop(s);
		getMin(s);
		pop(s);
		peek(s);

	}

//  + " and min is "+
	private static void peek(Stack<Integer> s) {
		System.out.println(s.peek() + " and min is " + ans.peek());
		System.out.println(s);
	}

	private static void pop(Stack<Integer> s) {

		int k = s.pop();
		if (k == ans.peek()) {
			ans.pop();
		}
		System.out.println(s);
	}

	private static void push(Stack<Integer> s, int value) {

		if (s.empty()) {
			ans.push(value);
		} else {
			int top = ans.peek();
			if (value <= top) {
				ans.push(value);
			}
		}
		s.push(value);
		System.out.println(s);
	}

	private static void getMin(Stack<Integer> s) {
		System.out.println(s.peek() + " and min is " + ans.peek());
	}

}
