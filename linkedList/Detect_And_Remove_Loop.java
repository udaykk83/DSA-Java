package linkedList;

public class Detect_And_Remove_Loop {

	static class ListNode {
		int data;
		ListNode next;

		ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static class pair {
		Object o1;
		Object o2;

		pair(Object o1, Object o2) {
			this.o1 = o1;
			this.o2 = o2;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(50);
		head.next = new ListNode(20);
		head.next.next = new ListNode(15);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(10);
		head.next.next.next.next.next = new ListNode(40);

		// Creating a loop for testing
		head.next.next.next.next.next.next = head.next.next.next;

		ListNode commonNode = detectCycle(head);
		if (commonNode != null) {
			removeLoop(head, commonNode);
		}

		printLinkedList(head);

	}

	private static void removeLoop(ListNode head, ListNode commonNode) {
		ListNode ptr1 = head;
		ListNode ptr2 = commonNode;

		while (ptr1 != ptr2) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		// now both ptr1 and ptr2 are pointing to first node in the loop

		ListNode prev = null;
		// here l = 1;
		int l = 1;
		while (ptr1.next != ptr2) {
			ptr1 = ptr1.next;
			prev = ptr1;
			l++;
		}
		System.out.println("length of loop is " + l);
		// OR you van say ptr1.next = null;
		prev.next = null;

	}

	private static ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		if (head == null || head.next == null) {
			return null;
		}

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return slow;
			}
		}
		return null;
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
