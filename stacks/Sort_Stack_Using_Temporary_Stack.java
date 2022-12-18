package stacks;

import java.util.Stack;

// TC O(N^2)
public class Sort_Stack_Using_Temporary_Stack {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(34);
		st.push(3);
		st.push(31);
		st.push(98);
		st.push(92);
		st.push(23);
		System.out.println(st);
		sortAStackByTempStack(st);
	}

//use a ans stack, and keep pushing until you get greater elements, 
//if ascending order is missing, then pop them back to original and repeat the operation
	private static void sortAStackByTempStack(Stack<Integer> st) {
		Stack<Integer> ans = new Stack<>();
		while (!st.empty()) {
			int top = st.pop();
			while (!ans.empty() && ans.peek() > top) {
				st.push(ans.pop());
			}
			ans.push(top);
		}
		System.out.println(ans);
	}

}
