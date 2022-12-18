package linkedList;

public class Kth_Node_From_End {

	static class ListNode {
		int data;
		ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(12);
		head.next.next = new ListNode(9);
		head.next.next.next = new ListNode(7);
		head.next.next.next.next = new ListNode(4);

		int k = 3;

		int l = findLength(head);
		System.out.println(l + " is length");
		System.out.println(k + "-kth node from end is " + findKthNodeFromEnd(head, l, k));

	}

	// total = n, from end = k, then n-k elements from start
	// we want the K<th> , so n-k+1
	// as i = 1, and ends at < n-k+1
	private static int findKthNodeFromEnd(ListNode head, int l, int k) {
		if (l == 0) {
			return -1;
		}
		if (k >= l)
			k = k % l;
		if (k == 0)
			return -1;
		System.out.println("k is " + k);

		// i starts from 1
		int i = 0;
		ListNode temp = head;
		while (i < l - k) {
			temp = temp.next;
			i++;
		}
		return temp.data;
	}

	private static int findLength(ListNode head) {
		if (head == null) {
			return 0;
		}
		int c = 0;
		ListNode temp = head;
		while (temp != null) {
			c++;
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		return c;
	}

}
