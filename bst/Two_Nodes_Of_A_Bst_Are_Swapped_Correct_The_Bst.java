package bst;

public class Two_Nodes_Of_A_Bst_Are_Swapped_Correct_The_Bst {

	private static TreeNode first, middle, last, prev;

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;

		}
	}

	private static void printViaInOrder(TreeNode root) {
		if (root == null)
			return;
		printViaInOrder(root.left);
		System.out.print(root.data + " ");
		printViaInOrder(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(10);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(12);
		root.right.left = new TreeNode(7);

		printViaInOrder(root);
		System.out.println();

		TreeNode temp = root;
		correctBSTNodes(temp);
		if (first == null) {
			printViaInOrder(root);
			System.out.println();
		} else if (last == null) {
			swapNodes(first, middle);
			printViaInOrder(root);
			System.out.println();
		} else {
			swapNodes(first, last);
			printViaInOrder(root);
			System.out.println();
		}

	}

	private static void swapNodes(TreeNode a, TreeNode b) {
		int temp = a.data;
		a.data = b.data;
		b.data = temp;

	}

	private static void correctBSTNodes(TreeNode root) {
		if (root == null)
			return;
		correctBSTNodes(root.left);
		if (prev != null && prev.data > root.data) {
			if (first == null) {
				// If in case only adjacent elements are swapped
				first = prev;
				middle = root;
			} else {
				// If far away elements are swapped
				last = root;
			}
		}
		prev = root;
		correctBSTNodes(root.right);
	}
}
