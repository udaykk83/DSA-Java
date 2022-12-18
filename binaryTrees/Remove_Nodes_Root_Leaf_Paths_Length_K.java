package binaryTrees;

public class Remove_Nodes_Root_Leaf_Paths_Length_K {

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

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(7);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(8);

		int k = 4;
		int level = 1;
		TreeNode temp = root;

		printInorder(temp);
		System.out.println();

		TreeNode ans = removeNodesWithPathLessThanKDistance(root, level, k);

		System.out.print("ans is : ");
		printInorder(ans);
		System.out.println();
	}

	private static TreeNode removeNodesWithPathLessThanKDistance(TreeNode root, int level, int k) {
		if (root == null) {
			return null;
		}
		root.left = removeNodesWithPathLessThanKDistance(root.left, level + 1, k);
		root.right = removeNodesWithPathLessThanKDistance(root.right, level + 1, k);

		// If its a leaf node and level less than K, then remove that and return null
		if (root.left == null && root.right == null && level < k) {
			return null;
		}
		// If level is greater than K, then return actual node
		return root;
	}

	private static void printInorder(TreeNode root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

}
