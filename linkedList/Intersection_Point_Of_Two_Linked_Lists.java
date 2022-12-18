package linkedList;

public class Intersection_Point_Of_Two_Linked_Lists {

	static class ListNode {
		int data;
		ListNode next;

		ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		ListNode head1 = new ListNode(3);
		head1.next = new ListNode(6);
		head1.next.next = new ListNode(9);
		head1.next.next.next = new ListNode(15);
		head1.next.next.next.next = new ListNode(30);

		ListNode head2 = new ListNode(10);
		head2.next = head1.next.next.next;
		head2.next.next = head1.next.next.next.next;

		printList(head1);

		printList(head2);

		findCommonNode(head1, head2);
	}

	private static void findCommonNode(ListNode head1, ListNode head2) {
		int l1 = findLength(head1);
		int l2 = findLength(head2);

		ListNode longest = null;
		ListNode shortest = null;
		int d = 0;
		if (l1 >= l2) {
			longest = head1;
			shortest = head2;
			d = l1 - l2;
		} else {
			longest = head2;
			shortest = head1;
			d = l2 - l1;
		}
		
		longest = findNodeAtKDistanceFromStart(longest, d);
		
		while (longest != null && shortest != null) {
			if (longest == shortest) {
				System.out.println(longest.data);
				break;
			}
			longest = longest.next;
			shortest = shortest.next;
		}
	}

	private static ListNode findNodeAtKDistanceFromStart(ListNode head, int k) {
		ListNode temp = head;
		int cnt = 0;
		while (cnt < k) {
			cnt++;
			temp = temp.next;
		}
		return temp;
	}

	private static int findLength(ListNode head1) {
		int l = 0;
		ListNode temp = head1;
		while (temp != null) {
			l++;
			temp = temp.next;
		}
		return l;
	}

	private static void printList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
