package binaryTrees;

public class Diameter_Of_A_Binary_Tree {

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

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);

		int d = calculateDiameter(root).d;
		System.out.println(d);
	}

	private static pair calculateDiameter(TreeNode root) {
		if (root == null)
			return new pair(-1, -1);
		pair lpair = calculateDiameter(root.left);
		pair rpair = calculateDiameter(root.right);
		int h = 1 + Math.max(lpair.h, rpair.h);
		int d = Math.max(2 + lpair.h + rpair.h, Math.max(lpair.d, rpair.d));
		return new pair(h, d);
	}

}
