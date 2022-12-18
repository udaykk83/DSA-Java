package binaryTrees;

import java.util.*;

public class Iterative_Traversal {

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

		ArrayList<Integer> pre = printPreOrderIteratively(root);
		System.out.println("pre " + pre);

		Collections.reverse(pre);
		System.out.println("post " + pre);

		ArrayList<Integer> in = printInOrderIteratively(root);
		System.out.println("in " + in);

	}

	private static ArrayList<Integer> printInOrderIteratively(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();
		TreeNode curr = root;

		while (curr != null || !st.empty()) {
			if (curr != null) {
				st.push(curr);
				curr = curr.left;
			} else {
				TreeNode temp = st.pop();
				ans.add(temp.data);
				curr = temp.right;
			}
		}
		return ans;
	}

	private static ArrayList<Integer> printPreOrderIteratively(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();
		TreeNode curr = root;

		while (curr != null || !st.empty()) {
			if (curr != null) {
				ans.add(curr.data);
				st.push(curr);
				curr = curr.left;
			} else {
				TreeNode temp = st.pop();
				curr = temp.right;
			}
		}
		return ans;
	}
}
