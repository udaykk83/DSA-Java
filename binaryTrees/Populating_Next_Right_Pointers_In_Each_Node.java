package binaryTrees;

public class Populating_Next_Right_Pointers_In_Each_Node {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode next;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
			this.next = null;
		}
	}

	static class Pair {
		int val;
		TreeNode node;

		Pair(TreeNode node, int val) {
			this.node = node;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right.right = new TreeNode(10);
		root.right.right.left = new TreeNode(11);
		root.left.left.right.left = new TreeNode(12);
		root.left.left.right.right = new TreeNode(13);
		root.right.right.left.left = new TreeNode(14);

		populateNextRightPointers(root);
	}

	private static void populateNextRightPointers(TreeNode root) {
		if (root == null)
			return;

		root.next = null;

		TreeNode tv = root;
		while (tv != null) {
			System.out.println();
			System.out.println(tv.data);
			TreeNode th = tv;
			while (th != null) {
				System.out.print(th.data + " ");

				if (th.left != null) {
					if (th.right != null) {
						th.left.next = th.right;
					} else {
						th.left.next = getNextRight(th.next);
					}
				}

				if (th.right != null) {
					th.right.next = getNextRight(th.next);
				}
				th = th.next;
			}

			if (tv.left != null) {
				tv = tv.left;
			} else if (tv.right != null) {
				tv = tv.right;
			} else {
				tv = getNextRight(tv.next);
			}
		}

	}

	private static TreeNode getNextRight(TreeNode th) {
		while (th != null) {
			if (th.left != null) {
				return th.left;
			} else if (th.right != null) {
				return th.right;
			}
			th = th.next;
		}
		return null;
	}

}
