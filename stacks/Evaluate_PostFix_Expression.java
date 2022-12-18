package stacks;

import java.util.Stack;

public class Evaluate_PostFix_Expression {

	public static void main(String[] args) {
		String str = "231*+9-";
		System.out.println(calculateValue(str));
	}

	private static int calculateValue(String str) {
		Stack<Integer> st = new Stack<>();
		char arr[] = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (isOperand(arr[i])) {
				st.push(arr[i] - '0');
			} else {
				int n2 = st.pop();
				int n1 = st.pop();
				int k = calculateByOperator(n1, n2, arr[i]);
				st.push(k);
			}
		}
		return st.peek();
	}

	private static int calculateByOperator(int n1, int n2, char c) {
		if (c == '+')
			return n1 + n2;
		else if (c == '-')
			return n1 - n2;
		else if (c == '*')
			return n1 * n2;
		else
			return n1 / n2;

	}

	private static boolean isOperand(char ch) {
		return (ch >= '0' && ch <= '9');
	}

}
