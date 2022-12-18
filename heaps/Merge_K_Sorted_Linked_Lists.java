package heaps;

import java.util.*;

public class Merge_K_Sorted_Linked_Lists {

	static class ListNode {
		int data;
		ListNode next;

		ListNode(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public static void main(String[] args) {
		int k = 3; // total number of linked lists

		// an array to store the head nodes of the linked lists
		ListNode[] lists = new ListNode[k];

		lists[0] = new ListNode(1);
		lists[0].next = new ListNode(5);
		lists[0].next.next = new ListNode(7);

		lists[1] = new ListNode(2);
		lists[1].next = new ListNode(3);
		lists[1].next.next = new ListNode(6);
		lists[1].next.next.next = new ListNode(9);

		lists[2] = new ListNode(4);
		lists[2].next = new ListNode(8);
		lists[2].next.next = new ListNode(10);

		ListNode ans = mergeLists(lists, k);

		while (ans != null) {
			System.out.print(ans.data + " -- ");
			ans = ans.next;
		}

	}

	static class ListComparator implements Comparator<ListNode> {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			if (o1.data > o2.data) {
				return 1;
			} else if (o1.data < o2.data) {
				return -1;
			} else {
				return 0;
			}
		}

	}

	private static ListNode mergeLists(ListNode[] li, int k) {

		// min heap
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new ListComparator());

		for (int i = 0; i < k; i++) {
			pq.add(li[i]);
		}

		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;

		while (pq.size() != 0) {
			ListNode temp = pq.poll();
			curr.next = temp;
			curr = curr.next;
			if (temp.next != null) {
				pq.add(temp.next);
			}
		}
		return dummy.next;
	}
}
