package binaryTrees;

import java.util.ArrayList;

public class Nodes_At_K_Distance_From_Leaf_Node {

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
		root.left.right = new TreeNode(16);
		root.left.right.left = new TreeNode(1);
		root.left.right.left.left = new TreeNode(4);
		root.left.right.right = new TreeNode(15);

		int k = 2;
		int path[] = new int[100];
		boolean vis[] = new boolean[100];
		int level = 0;
		printNodesAtKDistance(root, k, path, vis, level);
		System.out.println(ans);
	}

	static ArrayList<Integer> ans = new ArrayList<>();

	private static void printNodesAtKDistance(TreeNode root, int k, int[] path, boolean[] vis, int level) {
		if (root == null) {
			return;
		}
		path[level] = root.data;
		vis[level] = false;
		if (root.left == null && root.right == null && level - k >= 0 && vis[level - k] == false) {
			int val = path[level - k];
			ans.add(val);
			vis[level - k] = true;
			return;
		}
		printNodesAtKDistance(root.left, k, path, vis, 1 + level);
		printNodesAtKDistance(root.right, k, path, vis, 1 + level);
	}

}
