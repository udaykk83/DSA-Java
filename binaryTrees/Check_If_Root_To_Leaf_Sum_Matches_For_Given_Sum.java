package binaryTrees;

public class Check_If_Root_To_Leaf_Sum_Matches_For_Given_Sum {
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
		// root.right = new TreeNode(9);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(1);

		int k = 7;
		TreeNode temp = root;
		System.out.println(isSumPathExists(root, k, 0));
		sumRootToLeaf(temp, 0);
		System.out.println(ans);
		System.out.println(getMinDistanceToLeaf(root));

		altGetMinDistanceToLeaf(root, 0);
		System.out.println(res);
	}

	private static boolean isSumPathExists(TreeNode root, int k, int sum) {
		if (root == null) {
			return false;
		}
		sum = sum + root.data;
		if (root.left == null && root.right == null && sum == k) {
			return true;
		}
		return isSumPathExists(root.left, k, sum) || isSumPathExists(root.right, k, sum);
	}

	private static int ans = 0;

	public static void sumRootToLeaf(TreeNode root, int i) {
		if (root == null) {
			return;
		}
		int sum = i * 10 + root.data;
		if (root.left == null && root.right == null) {
			ans = ans + sum;
			return;
		}
		sumRootToLeaf(root.left, sum);
		sumRootToLeaf(root.right, sum);
	}

	public static int getMinDistanceToLeaf(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}

		if (root.left == null && root.right == null) {
			return 0;
		}

		return 1 + Math.min(getMinDistanceToLeaf(root.left), getMinDistanceToLeaf(root.right));
	}

	static int res = Integer.MAX_VALUE;;

	public static void altGetMinDistanceToLeaf(TreeNode root, int l) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			res = Math.min(res, l);
			return;
		}
		altGetMinDistanceToLeaf(root.left, l + 1);
		altGetMinDistanceToLeaf(root.right, l + 1);

	}
}
