package bst;

public class Check_If_A_Binary_Tree_Is_Bst_Or_Not {

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

	private static TreeNode insert(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		if (val > root.data) {
			root.right = insert(root.right, val);
		} else {
			root.left = insert(root.left, val);
		}
		return root;
	}

	private static void printViaInOrder(TreeNode root) {
		if (root == null)
			return;
		printViaInOrder(root.left);
		System.out.print(root.data + " ");
		printViaInOrder(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = insert(null, 8);
		root = insert(root, 3);
		root = insert(root, 6);
		root = insert(root, 10);
		root = insert(root, 4);
		root = insert(root, 7);
		root = insert(root, 1);
		root = insert(root, 14);
		root = insert(root, 13);

		root.right.right = new TreeNode(5);
		printViaInOrder(root);
		System.out.println();

		System.out.println(check_If_A_BT_Is_BST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}

	private static boolean check_If_A_BT_Is_BST(TreeNode root, int leftMaxValue, int rightMinValue) {
		if (root == null) {
			return true;
		}
		// If it's not in limit, return false
		boolean isInLimits = root.data > leftMaxValue && root.data < rightMinValue;
		if (!isInLimits) {
			return false;
		}

		// If LST is not a BST, return false
		boolean isLSTaBST = check_If_A_BT_Is_BST(root.left, leftMaxValue, root.data - 1);
		if (!isLSTaBST) {
			return false;
		}

		boolean isRSTaBST = check_If_A_BT_Is_BST(root.left, root.data + 1, rightMinValue);
		return isInLimits && isLSTaBST && isRSTaBST;
	}
}
