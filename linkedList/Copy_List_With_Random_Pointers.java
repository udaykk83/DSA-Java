package linkedList;

import java.util.*;

public class Copy_List_With_Random_Pointers {

	static class ListNode {
		int data;
		ListNode next;
		ListNode random;

		ListNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		head.random = head.next.next.next;
		head.next.next.random = head.next;
		traverse(head);

		ListNode temp1 = head;
		temp1 = copyUsingHashMap(temp1);
		traverse(temp1);

		ListNode temp2 = head;
		temp2 = copyUsingConstantSpace(temp2);
		traverse(temp2);

	}

	private static ListNode copyUsingConstantSpace(ListNode temp2) {

		ListNode curr = temp2;

		// Create a new duplicate node after original node, and move ahead two steps,
		// skipping duplicate, o1-o2-o3 --> o1-d1-o2-d2-o3-d3
		while (curr != null) {
			ListNode after = curr.next;
			ListNode newnode = new ListNode(curr.data);
			curr.next = newnode;
			newnode.next = after;
			curr = curr.next.next;
		}

		// Attach random pointers to dupicate list
		curr = temp2;

		while (curr != null) {
			if (curr.random != null) {
				curr.next.random = curr.random.next;
			}
			curr = curr.next.next;
		}

		// Decouple two lists from merged
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		curr = temp2;
		while (curr != null) {
			ListNode duplicate = curr.next;
			ListNode after = curr.next.next;
			tail.next = duplicate;
			curr.next = curr.next.next;
			tail = tail.next;
			curr = after;
		}

		return dummy.next;
	}

	private static ListNode copyUsingHashMap(ListNode temp1) {
		HashMap<ListNode, ListNode> map = new HashMap<>();
		ListNode curr = temp1;

		// create replica nodes
		while (curr != null) {
			map.put(curr, new ListNode(curr.data));
			curr = curr.next;
		}

		// link next nodes and random nodes
		curr = temp1;
		while (curr != null) {
			ListNode dupCurr = map.get(curr);
			dupCurr.next = map.get(curr.next);
			if (curr.random != null) {
				dupCurr.random = map.get(curr.random);
			}
			curr = curr.next;
		}
		return map.get(temp1);
	}

	public static void traverse(ListNode head) {
		ListNode temp = head;
		// traverse the linked list
		while (head != null) {
			// print current node data and random pointer data
			if (head.random != null) {
				System.out.print(head.data + "(" + head.random.data + ") —> ");
			} else {
				System.out.print(head.data + "(" + "X" + ") —> ");
			}

			// advance to the next node
			head = head.next;
		}

		System.out.println("null");
	}

}
