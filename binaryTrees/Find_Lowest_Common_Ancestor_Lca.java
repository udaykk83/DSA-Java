package binaryTrees;

public class Find_Lowest_Common_Ancestor_Lca {

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

		int n1 = 4;
		int n2 = 3;
		
		TreeNode lca = findLCA(root, n1, n2);

		System.out.print("ans ");
		
		if (n1Present && n2Present) {
			System.out.println(lca.data);
			int d1 = findDistance(lca, n1, 0);
			int d2 = findDistance(lca, n2, 0);
			System.out.println("dist " + (d1 + d2));
		} else if (!n1Present && !n2Present) {
			System.out.println("NO");
		} else {
			int val = lca.data == n1 ? n2 : n1;
			boolean ifValPresent = checkIfValueOccurs(lca, val);
			if (ifValPresent) {
				System.out.println(lca.data);
				int d1 = findDistance(lca, n1, 0);
				int d2 = findDistance(lca, n2, 0);
				System.out.println("dist " + (d1 + d2));
			} else {
				System.out.println("NO");
			}
		}
	}

	private static int findDistance(TreeNode root, int key, int level) {
		if (root == null) {
			return -1;
		}
		if (root.data == key) {
			return level;
		}
		int k = findDistance(root.left, key, level + 1);
		if (k != -1) {
			return k;
		}
		return findDistance(root.right, key, level + 1);
	}

	private static boolean checkIfValueOccurs(TreeNode root, int val) {
		if (root == null) {
			return false;
		}
		if (root.data == val) {
			return true;
		}
		return checkIfValueOccurs(root.left, val) || checkIfValueOccurs(root.right, val);
	}

	static boolean n1Present = false;
	static boolean n2Present = false;

	private static TreeNode findLCA(TreeNode root, int n1, int n2) {
		if (root == null) {
			return null;
		}
		if (root.data == n1) {
			n1Present = true;
			return root;
		}
		if (root.data == n2) {
			n2Present = true;
			return root;
		}
		TreeNode leftlca = findLCA(root.left, n1, n2);
		TreeNode rightlca = findLCA(root.right, n1, n2);
		if (leftlca != null && rightlca != null) {
			return root;
		} else if (leftlca != null) {
			return leftlca;
		} else {
			return rightlca;
		}
	}

}
