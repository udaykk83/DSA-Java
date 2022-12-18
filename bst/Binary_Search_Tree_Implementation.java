package bst;

public class Binary_Search_Tree_Implementation {

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

	private static TreeNode insert(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		if (val > root.data) {
			root.right = insert(root.right, val);
		} else {
			root.left = insert(root.left, val);
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = insert(null, 8);
		root = insert(root, 3);
		root = insert(root, 6);
		root = insert(root, 10);
		root = insert(root, 4);
		root = insert(root, 7);
		root = insert(root, 1);
		root = insert(root, 14);
		root = insert(root, 13);

		printViaInOrder(root);
		System.out.println();

		root = delete(root, 8);

		printViaInOrder(root);
		System.out.println();
	}

	private static void printViaInOrder(TreeNode root) {
		if (root == null)
			return;
		printViaInOrder(root.left);
		System.out.print(root.data + " ");
		printViaInOrder(root.right);
	}

	private static TreeNode delete(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		if (val > root.data) {
			root.right = delete(root.right, val);
		} else if (val < root.data) {
			root.left = delete(root.left, val);
		} else {
			// check if it's a leaf node or a single child node
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// It has both children, so Find MIN from Right Sub-Tree and replace it with
			// value to be deleted that is the root
			// then delete the replaced value from Right Sub-Tree
			TreeNode minValOnRight = getMinFromRightSubTree(root.right);
			root.data = minValOnRight.data;
			root.right = delete(root.right, minValOnRight.data);
		}
		return root;
	}

	private static TreeNode getMinFromRightSubTree(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

}
