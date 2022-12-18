package binaryTrees;

import java.util.*;

public class Zigzag_Tree_Traversal {

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

		ArrayList<ArrayList<Integer>> ans = printZigZagFashion(root);
		System.out.println("zigzag " + ans);

		ArrayList<ArrayList<Integer>> ans1 = printZigZagUsingQueue(root);
		System.out.println(ans1);
	}

	private static ArrayList<ArrayList<Integer>> printZigZagUsingQueue(TreeNode root) {

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		TreeNode temp = root;
		boolean fromLeft = true;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(temp);

		while (!q.isEmpty()) {
			int n = q.size();
			ArrayList<Integer> tempans = new ArrayList<Integer>();
			while (n > 0) {
				TreeNode curr = q.poll();
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
				tempans.add(curr.data);
				n--;
			}
			if (fromLeft) {

			} else {
				Collections.reverse(tempans);
			}
			fromLeft = !fromLeft;
			ans.add(tempans);
		}
		return ans;
	}

	private static ArrayList<ArrayList<Integer>> printZigZagFashion(TreeNode root) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		TreeNode temp = root;

		Deque<TreeNode> dq = new LinkedList<TreeNode>();
		dq.addLast(temp);

		boolean fromLeft = true;

		while (!dq.isEmpty()) {
			int n = dq.size();
			ArrayList<Integer> tempans = new ArrayList<Integer>();
			while (n > 0) {
				TreeNode curr;
				if (fromLeft) {
					curr = dq.pollFirst();
					if (curr.left != null) {
						dq.addLast(curr.left);
					}
					if (curr.right != null) {
						dq.addLast(curr.right);
					}
				} else {
					curr = dq.pollLast();
					if (curr.right != null) {
						dq.addFirst(curr.right);
					}
					if (curr.left != null) {
						dq.addFirst(curr.left);
					}
				}
				tempans.add(curr.data);
				n--;
			}
			ans.add(tempans);
			fromLeft = !fromLeft;
		}

		return ans;
	}

}
