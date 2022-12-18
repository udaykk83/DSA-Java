package binaryTrees;

public class Check_If_A_Binary_Tree_Is_Height_Balanced {

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

	static class Info {
		boolean isbal;
		int h;

		Info(boolean isbal, int h) {
			this.isbal = isbal;
			this.h = h;
		}
	}

	public static void main(String[] args) {

		TreeNode r = new TreeNode(15);
		r.left = new TreeNode(10);
		// r.right = new TreeNode(20);
		r.left.left = new TreeNode(8);
		r.left.right = new TreeNode(12);
		// r.right.left = new TreeNode(16);
		// r.right.right = new TreeNode(25);

		System.out.println(checkIfATreeIsHeightBal(r).isbal);

	}

	private static Info checkIfATreeIsHeightBal(TreeNode root) {
		if (root == null) {
			return new Info(true, -1);
		}
		Info linfo = checkIfATreeIsHeightBal(root.left);
		Info rinfo = checkIfATreeIsHeightBal(root.right);
		if (linfo.isbal && rinfo.isbal && Math.abs(linfo.h - rinfo.h) <= 1) {
			return new Info(true, 1 + Math.max(linfo.h, rinfo.h));
		} else {
			// pass any value as h, doesn't count
			return new Info(false, Integer.MAX_VALUE);
		}
	}

}
