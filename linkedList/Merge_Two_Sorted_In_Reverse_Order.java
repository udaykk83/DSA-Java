package linkedList;

public class Merge_Two_Sorted_In_Reverse_Order {

	static class ListNode {
		int data;
		ListNode next;

		ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private static ListNode mergeTwoSortedLinkedListsInReverseOrder(ListNode head1, ListNode head2) {

		if (head1 == null && head2 == null) {
			return null;
		}

		ListNode currhead = null;
		if (head1 == null) {
			currhead = head2;
		}
		if (head2 == null) {
			currhead = head1;
		}

		if (head1.data <= head2.data) {
			currhead = head1;
			head1 = head1.next;
		} else {
			currhead = head2;
			head2 = head2.next;
		}

		currhead.next = null;

		while (head1 != null && head2 != null) {
			ListNode temp = null;
			if (head1.data <= head2.data) {
				temp = head1;
				head1 = head1.next;
				temp.next = currhead;
				currhead = temp;
			} else {
				temp = head2;
				head2 = head2.next;
				temp.next = currhead;
				currhead = temp;
			}
		}

		while (head1 != null) {
			ListNode temp = head1;
			head1 = head1.next;
			temp.next = currhead;
			currhead = temp;
		}

		while (head2 != null) {
			ListNode temp = head2;
			head2 = head2.next;
			temp.next = currhead;
			currhead = temp;
		}

		return currhead;
	}

	private static void printLinkedList(ListNode head) {
		ListNode temp = head;
		int c = 0;
		while (temp != null && c++ < 20) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode head1 = new ListNode(6);
		head1.next = new ListNode(12);
		head1.next.next = new ListNode(19);
		head1.next.next.next = new ListNode(27);
		head1.next.next.next.next = new ListNode(34);
		printLinkedList(head1);

		ListNode head2 = new ListNode(3);
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(9);
		head2.next.next.next = new ListNode(47);
		head2.next.next.next.next = new ListNode(53);
		printLinkedList(head2);

		ListNode head = mergeTwoSortedLinkedListsInReverseOrder(head1, head2);

		printLinkedList(head);
	}

}
