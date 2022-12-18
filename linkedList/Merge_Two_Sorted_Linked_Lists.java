package linkedList;

public class Merge_Two_Sorted_Linked_Lists {

	static class ListNode {
		int data;
		ListNode next;

		ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	// create a Dummy Node in the start and point a currNode to dummy and start
	// appending to the list

	private static ListNode mergeTwoSortedLinkedLists(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode currhead = dummy;

		while (head1 != null && head2 != null) {
			if (head1.data <= head2.data) {
				currhead.next = head1;
				head1 = head1.next;
				currhead = currhead.next;
			} else {
				currhead.next = head2;
				head2 = head2.next;
				currhead = currhead.next;
			}
		}

		if (head2 != null) {
			currhead.next = head2;
		}

		if (head1 != null) {
			currhead.next = head1;
		}

		return dummy.next;
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

		ListNode head = mergeTwoSortedLinkedLists(head1, head2);

		printLinkedList(head);
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
