package binaryTrees;

import java.util.ArrayList;

public class Nodes_At_K_Distance_From_Given_Node {

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
		printNodesAtKDistanceFromGivenNode(root, root.left.right, k);
		System.out.println(ans);
	}

	private static void printNodesAtKDistanceFromGivenNode(TreeNode root, TreeNode target, int k) {
		if (root == null || target == null || k < 0) {
			System.out.println("NO");
		}
		printNodesAtKDistNodes(root, target, k);
	}

	static ArrayList<Integer> ans = new ArrayList<>();

	private static int printNodesAtKDistNodes(TreeNode root, TreeNode target, int k) {
		if (root == null) {
			return -1;
		}

		if (root == target) {
			printNodesAtKLevelDown(root, k);
			return 0;
		}
		int left_dist = printNodesAtKDistNodes(root.left, target, k);

		if (left_dist != -1) {
			// If parent is at K distance
			if (left_dist + 1 == k) {
				ans.add(root.data);
			} else {
				// check for right subtree, as left is found node, or already covered
				// k-2-left_dist
				printNodesAtKLevelDown(root.right, k - 2 - left_dist);
			}
			return 1 + left_dist;
		}

		int right_dist = printNodesAtKDistNodes(root.right, target, k);

		if (right_dist != -1) {
			if (right_dist + 1 == k) {
				ans.add(root.data);
			} else {
				printNodesAtKLevelDown(root.left, k - 2 - right_dist);
			}
			return 1 + right_dist;
		}
		return -1;
	}

	private static void printNodesAtKLevelDown(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		if (k < 0) {
			return;
		}
		if (k == 0) {
			ans.add(root.data);
		}
		printNodesAtKLevelDown(root.left, k - 1);
		printNodesAtKLevelDown(root.right, k - 1);
	}

}
