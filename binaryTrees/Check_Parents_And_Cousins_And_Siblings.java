package binaryTrees;

public class Check_Parents_And_Cousins_And_Siblings {

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

		TreeNode p = findParent(root, 1 + 1);
		int ans = p != null ? p.data : -1;
		System.out.println("parent is " + ans);

		System.out.println("siblings " + checkIfNodesAreSiblings(root, root.left.left, root.left.right));

		System.out.println("cousins " + checkIfNodesAreCousins(root, root.left.left, root.left.right));

	}

	private static boolean checkIfNodesAreCousins(TreeNode root, TreeNode left, TreeNode right) {
		int leftLevel = getLevelOfNode(root, left, 1);
		int rightLevel = getLevelOfNode(root, right, 1);
		System.out.println(leftLevel + " " + rightLevel);
		return leftLevel == rightLevel && !checkIfNodesAreSiblings(root, left, right);
	}

	private static int getLevelOfNode(TreeNode root, TreeNode key, int level) {
		if (root == null) {
			return 0;
		}
		if (root == key) {
			return level;
		}
		int l = getLevelOfNode(root.left, key, level + 1);
		if (l != 0) {
			return l;
		}
		return getLevelOfNode(root.right, key, level + 1);
	}

	private static boolean checkIfNodesAreSiblings(TreeNode root, TreeNode leftChild, TreeNode rightChild) {
		if (root == null) {
			return false;
		}
		return (root.left == leftChild && root.right == rightChild)
				|| (root.right == leftChild && root.left == rightChild)
				|| checkIfNodesAreSiblings(root.left, leftChild, rightChild)
				|| checkIfNodesAreSiblings(root.right, leftChild, rightChild);
	}

	private static TreeNode findParent(TreeNode root, int k) {
		if (root == null) {
			return null;
		}
		if (root.data == k) {
			return null;
		}
		if (root.left != null && root.left.data == k) {
			return root;
		}
		if (root.right != null && root.right.data == k) {
			return root;
		}

		TreeNode parent = findParent(root.left, k);
		if (parent != null) {
			return parent;
		}

		parent = findParent(root.right, k);
		return parent;
	}

}
