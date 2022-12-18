package binaryTrees;

import java.util.ArrayList;

public class Find_All_Root_To_Leaf_Path_In_A_Binary_Tree {

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

	static class pair {
		int h;
		int d;

		pair(int d, int h) {
			this.d = d;
			this.h = h;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(12);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(11);
		// root.right.right = new TreeNode(9);

		TreeNode temp = root;
		ArrayList<Integer> ans = new ArrayList<>();
		findAllRootToLeafPaths(root, ans);

		mini = getMinDistanceToLeaf(temp);
		System.out.println(mini);

		getMinDistToLeaf(temp, -1);
		System.out.println(minAns);
	}

	private static int minAns = Integer.MAX_VALUE;;

	private static void getMinDistToLeaf(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		k++;
		System.out.println(root.data + " root and k " + k);
		if (root.left == null && root.right == null) {
			minAns = Math.min(minAns, k);
			System.out.println("root " + root.data + "  --> k is " + k + " -- ans is " + minAns);
		}
		getMinDistToLeaf(root.left, k);
		getMinDistToLeaf(root.right, k);
	}

	private static void findAllRootToLeafPaths(TreeNode root, ArrayList<Integer> ans) {
		if (root == null) {
			return;
		}
		ans.add(root.data);
		System.out.println(root.data + " root and ans is " + ans);
		if (root.left == null && root.right == null) {
			System.out.println(root.data + " --> " + ans);
		}
		findAllRootToLeafPaths(root.left, ans);
		findAllRootToLeafPaths(root.right, ans);
		ans.remove(ans.size() - 1);
	}

	private static int mini = Integer.MAX_VALUE;

	public static int getMinDistanceToLeaf(TreeNode node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}

		if (node.left == null && node.right == null) {
			return 0;
		}

		int l = getMinDistanceToLeaf(node.left);
		int r = getMinDistanceToLeaf(node.right);

		return 1 + Math.min(l, r);
	}

}
