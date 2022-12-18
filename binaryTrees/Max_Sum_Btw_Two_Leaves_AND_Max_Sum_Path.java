package binaryTrees;

public class Max_Sum_Btw_Two_Leaves_AND_Max_Sum_Path {

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

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.right.right = new TreeNode(8);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
//		root.left.right.left = new TreeNode(1);
//		root.left.right.left.left = new TreeNode(4);
//		root.left.right.right = new TreeNode(15);

		TreeNode root1 = new TreeNode(44);
		root1.left = new TreeNode(9);
		root1.right = new TreeNode(13);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(-5);
		root1.right.left = new TreeNode(-6);
		root1.right.right = new TreeNode(-7);

		getMaxSumBtwLeaves(root);
		System.out.println(ans);

		getMaxSumofAPath(root1);
		System.out.println(res);
	}

	static int res = Integer.MIN_VALUE;

	private static int getMaxSumofAPath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.data;
		}

		int l = getMaxSumofAPath(root.left);
		int r = getMaxSumofAPath(root.right);

		// https://www.youtube.com/watch?v=mfDf4JWy6so&list=PLt4nG7RVVk1hXIW5w54uKEN25MqHNS7_A&index=82
		int currPathSum = Math.max(root.data, root.data + Math.max(l, r));
		res = Math.max(res, root.data + l + r);
		return currPathSum;
	}

	static int ans = Integer.MIN_VALUE;

	private static int getMaxSumBtwLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.data;
		}
		int l = getMaxSumBtwLeaves(root.left);
		int r = getMaxSumBtwLeaves(root.right);
		// 5
		// N -3 , then it will return wrong, if we have negative numbers
		if (root.left != null && root.right != null) {
			ans = Math.max(ans, l + r + root.data);
			return root.data + Math.max(l, r);
		}
		// if left is null, then pass sum of right and root.data
		else if (root.left == null) {
			return root.data + r;
		} else {
			return root.data + l;
		}
	}

}
