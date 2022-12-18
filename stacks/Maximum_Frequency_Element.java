package stacks;

import java.util.HashMap;
import java.util.Stack;

public class Maximum_Frequency_Element {
	static HashMap<Integer, Integer> hash = new HashMap<>();
	static HashMap<Integer, Stack<Integer>> freqStack = new HashMap<>();
	static int maxFreq = 0;

	public static void main(String[] args) {
		push(4);
		push(6);
		push(7);
		push(6);
		push(8);
		System.out.println(freqStack);
		pop();
		pop();
		pop();
	}

	private static void pop() {
		if (maxFreq < 1) {
			System.out.println("no data");
			return;
		}
		// get the element
		int max = freqStack.get(maxFreq).pop();

		// decrement the freq count
		hash.put(max, hash.get(max) - 1);

		// Decrement the max freq
		if (freqStack.get(maxFreq).empty()) {
			maxFreq--;
		}
		System.out.println(max);
	}

	private static void push(int value) {
		// increment the curr elemnt count
		int currFreq = hash.getOrDefault(value, 0) + 1;
		hash.put(value, currFreq);
		
		// Find out the maxFreq of any element, used for popping
		maxFreq = Math.max(currFreq, maxFreq);
		
		// insert in to the map, according to the Freq
		if (freqStack.containsKey(currFreq)) {
			freqStack.get(currFreq).push(value);
		} else {
			Stack<Integer> st = new Stack<>();
			st.push(value);
			freqStack.put(currFreq, st);
		}

	}

}
