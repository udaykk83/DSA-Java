package linkedList;

import linkedList.Kth_Node_From_End.ListNode;

public class Middle_Of_The_Linked_List {

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

		System.out.println(findMiddleOfList(head));
	}

	private static int findMiddleOfList(ListNode head) {
		if (head == null) {
			return -1;
		} else if (head.next == null) {
			return head.data;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

}
