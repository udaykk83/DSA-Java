package linkedList;

public class Reverse_K_Nodes {

	static class ListNode {
		int data;
		ListNode next;

		ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(6);
		head.next = new ListNode(12);
		head.next.next = new ListNode(9);
		head.next.next.next = new ListNode(7);
		head.next.next.next.next = new ListNode(4);

		int k = 2;

		printLinkedList(head);

		ListNode temp = head;
		ListNode newHead = reverse_K_Nodes(temp, k);
		printLinkedList(newHead);

	}

	private static ListNode reverse_K_Nodes(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode after = null;
		ListNode prev = null;

		ListNode curr = head;

		int cnt = 0;

		while (curr != null && cnt < k) {
			after = curr.next;
			curr.next = prev;
			prev = curr;
			curr = after;
			cnt++;
		}
		// as head is starting of the node, draw diagram
		head.next = reverse_K_Nodes(curr, k);
		return prev;
	}

	private static void printLinkedList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
