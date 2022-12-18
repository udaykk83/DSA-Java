package binaryTrees;

public class Check_If_Two_Binary_Trees_Are_Identical {
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

		TreeNode r1 = new TreeNode(15);
		r1.left = new TreeNode(10);
		r1.right = new TreeNode(20);
		r1.left.left = new TreeNode(8);
		r1.left.right = new TreeNode(12);
		r1.right.left = new TreeNode(16);
		r1.right.right = new TreeNode(25);

		// construct the second tree
		TreeNode r2 = new TreeNode(15);
		r2.left = new TreeNode(10);
		r2.right = new TreeNode(20);
		r2.left.left = new TreeNode(8);
		r2.left.right = new TreeNode(12);
		r2.right.left = new TreeNode(16);
		r2.right.right = new TreeNode(25);

		System.out.println(areTwoTreesIdentical(r1, r2));

		TreeNode r3 = new TreeNode(15);
		r3.left = new TreeNode(10);
		r3.right = new TreeNode(10);
		r3.left.left = new TreeNode(8);
		r3.left.right = new TreeNode(12);
		r3.right.left = new TreeNode(12);
		r3.right.right = new TreeNode(8);

		System.out.println(checkIfATreeIsSymetrical(r3.left, r3.right));

	}

	private static boolean checkIfATreeIsSymetrical(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 == null)
			return true;
		if (r1 == null || r2 == null)
			return false;
		boolean areValuesEqual = r1.data == r2.data;
		return areValuesEqual && areTwoTreesIdentical(r1.left, r2.right) && areTwoTreesIdentical(r1.right, r2.left);
	}

	private static boolean areTwoTreesIdentical(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 == null)
			return true;
		if (r1 == null || r2 == null)
			return false;
		boolean areValuesEqual = r1.data == r2.data;
		return areValuesEqual && areTwoTreesIdentical(r1.left, r2.left) && areTwoTreesIdentical(r1.right, r2.right);
	}

}
