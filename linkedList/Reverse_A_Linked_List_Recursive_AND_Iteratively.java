package linkedList;

public class Reverse_A_Linked_List_Recursive_AND_Iteratively {

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

		printLinkedList(head);

		ListNode temp = head;

		ListNode newHead1 = reverseALinkedListRecursively(temp);

		printLinkedList(newHead1);

		ListNode temp2 = newHead1;

		ListNode newHead2 = reverseALinkedListIteratively(temp2);

		printLinkedList(newHead2);

	}

	private static ListNode reverseALinkedListIteratively(ListNode temp) {

		ListNode prev = null;
		ListNode after = null;
		ListNode curr = temp;

		if (curr == null)
			return null;
		if (curr.next == null)
			return curr;

		// handles for all cases like 0,1 and n
		while (curr != null) {
			after = curr.next;
			curr.next = prev;
			prev = curr;
			curr = after;
		}

		return prev;
	}

	private static ListNode reverseALinkedListRecursively(ListNode temp) {
		if (temp == null)
			return null;
		else if (temp.next == null)
			return temp;

		ListNode newHead = reverseALinkedListRecursively(temp.next);

		temp.next.next = temp;
		temp.next = null;
		return newHead;
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
