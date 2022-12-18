package stacks;

import java.util.*;

public class Stack_Implementation {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(10);
		st.push(15);
		st.push(30);
		st.push(20);
		st.push(5);
		System.out.println(st);
		System.out.println(st.peek());
		System.out.println(st.pop() + " " + st);
		System.out.println(st.empty());
	}

}
