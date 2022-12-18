package queue;

import java.util.*;

public class Queue_Implementation {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		System.out.println(q);
		q.add(1);
		q.add(15);
		q.add(18);
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q);
		System.out.println(q.isEmpty());
	}

}
