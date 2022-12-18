package binaryTrees;

import java.util.ArrayList;

public class Left_And_Right_View_Of_Binary_Tree {

	private static ArrayList<Integer> ans = new ArrayList<>();
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

		TreeNode temp = root;

		getleftViewOrder(temp, 1);
		System.out.println(ans);
		ans.clear();

		maxLevel = Integer.MIN_VALUE;

		getrightViewOrder(temp, 1);
		System.out.println(ans);

	}

	private static void getleftViewOrder(TreeNode root, int h) {
		if (root == null)
			return;
		if (h > maxLevel) {
			ans.add(root.data);
			maxLevel = h;
		}
		getleftViewOrder(root.left, 1 + h);
		getleftViewOrder(root.right, 1 + h);
	}

	private static void getrightViewOrder(TreeNode root, int h) {
		if (root == null)
			return;
		if (h > maxLevel) {
			ans.add(root.data);
			maxLevel = h;
		}
		getrightViewOrder(root.right, 1 + h);
		getrightViewOrder(root.left, 1 + h);

	}

}
