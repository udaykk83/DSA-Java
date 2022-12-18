package binaryTrees;

import java.util.ArrayList;

public class Boundary_Traversal_Of_A_Binary_Tree {

	private static ArrayList<Integer> ans = new ArrayList<>();
	private static ArrayList<Integer> left = new ArrayList<>();
	private static ArrayList<Integer> bottom = new ArrayList<>();
	private static ArrayList<Integer> right = new ArrayList<>();
	static int maxLevel = Integer.MIN_VALUE;

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

	static class Pair {
		int val;
		TreeNode TreeNode;

		Pair(TreeNode TreeNode, int val) {
			this.TreeNode = TreeNode;
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

		ans.add(root.data);

		// add data in top down fashion
		TreeNode temp = root;
		getLeftView(temp.left);
		System.out.println("left " + left);

		// add data in bottom up fashion// or reverse the List later
		temp = root;
		getRightView(temp.right);
		System.out.println("right " + right);

		temp = root;
		if (!(root.left == null && root.right == null)) {
			getBottomViewLeaves(temp);
		}
		System.out.println("bottom " + bottom);

		ans.addAll(left);
		ans.addAll(bottom);
		ans.addAll(right);
		System.out.println("boundary" + ans);

	}

	private static void getBottomViewLeaves(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			bottom.add(root.data);
			return;
		}
		getBottomViewLeaves(root.left);
		getBottomViewLeaves(root.right);
	}

	private static void getRightView(TreeNode root) {
		if (root == null) {
			return;
		}
		// skip if it's a leaf node
		if (root.left == null && root.right == null) {
			return;
		}
		if (root.right != null) {
			getRightView(root.right);
			right.add(root.data);
		} else if (root.left != null) {
			getRightView(root.left);
			right.add(root.data);
		}
	}

	private static void getLeftView(TreeNode root) {
		if (root == null) {
			return;
		}
		// skip if it's a leaf node
		if (root.left == null && root.right == null) {
			return;
		}
		if (root.left != null) {
			left.add(root.data);
			getLeftView(root.left);
		} else if (root.right != null) {
			left.add(root.data);
			getLeftView(root.right);
		}
	}

}
