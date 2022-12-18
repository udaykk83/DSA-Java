package binaryTrees;

public class Find_If_The_Sequence_Is_Present_As_A_Root_To_Leaf_Path_ {

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

	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.right = new TreeNode(9);
		root.right.right = new TreeNode(3);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(1);
		root.left.right.left.left = new TreeNode(4);
		root.left.right.right = new TreeNode(1);

		int[] seq = { 2, 7, 6, 1 };
		TreeNode temp = root;

		printInorder(temp);
		System.out.println();

		int idx = 0;
		System.out.println(isPathPresent(root, idx, seq));
	}

	private static boolean isPathPresent(TreeNode root, int idx, int[] seq) {
		if (root == null) {
			return false;
		}
		if (idx >= seq.length) {
			return false;
		}
		if (root.data != seq[idx]) {
			return false;
		}
		if (root.left == null && root.right == null && root.data == seq[idx] && idx == seq.length - 1) {
			return true;
		}
		return isPathPresent(root.left, idx + 1, seq) || isPathPresent(root.right, idx + 1, seq);
	}

	private static void printInorder(TreeNode root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

}
