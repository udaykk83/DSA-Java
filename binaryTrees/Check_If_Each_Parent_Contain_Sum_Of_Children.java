package binaryTrees;

public class Check_If_Each_Parent_Contain_Sum_Of_Children {

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

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.right.right = new TreeNode(8);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
//		root.left.right.left = new TreeNode(1);
//		root.left.right.left.left = new TreeNode(4);
//		root.left.right.right = new TreeNode(15);

		System.out.println(checkIfPropertyExists(root));

		TreeNode root1 = new TreeNode(44);
		root1.left = new TreeNode(9);
		root1.right = new TreeNode(13);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(7);

		System.out.println(checkIfBtisASumTree(root1));

	}

	private static boolean checkIfBtisASumTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		if (checkIfBtisASumTree(root.left) && checkIfBtisASumTree(root.right)) {
			int l = 0;
			if (root.left == null) {
				l = root.left.data;

			} // checking whether left node is leaf node
			else if (root.left.left == null && root.left.right == null) {
				l = root.left.data;
			} else {
				l = 2 * root.left.data;
			}

			int r = 0;
			if (root.right == null) {
				r = root.right.data;

			} // checking whether right node is leaf node
			else if (root.right.left == null && root.right.right == null) {
				r = root.right.data;
			} else {
				r = 2 * root.right.data;
			}

			if (l + r == root.data) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	private static boolean checkIfPropertyExists(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		int l = root.left != null ? root.left.data : 0;
		int r = root.right != null ? root.right.data : 0;

		return (root.data == l + r) && checkIfPropertyExists(root.left) && checkIfPropertyExists(root.right);
	}

}
