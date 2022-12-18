package binaryTrees;

import binaryTrees.Height_Of_A_Binary_Tree.TreeNode;

public class Binary_Tree_Implementation {

	
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

		printPreOrder(root);
	}

	private static void printPreOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
	
}
