package binaryTrees;

public class Height_Of_A_Binary_Tree {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
		root.right.left = new TreeNode(16);
		root.right.right = new TreeNode(25);

		int h = calculateHeight(root);
		System.out.println(h);
	}

	private static int calculateHeight(TreeNode root) {
		if (root == null) {
			return -1;
		}
		int lh = calculateHeight(root.left);
		int rh = calculateHeight(root.right);
		return Math.max(lh, rh) + 1;
	}

}
