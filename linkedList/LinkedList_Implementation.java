package linkedList;

public class LinkedList_Implementation {

	static class ListNode {
		int data;
		ListNode next;

		ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(10);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(1);

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

}
