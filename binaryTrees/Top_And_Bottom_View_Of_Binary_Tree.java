package binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class Top_And_Bottom_View_Of_Binary_Tree {

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

	static class Pair {
		int val;
		TreeNode node;

		Pair(TreeNode node, int val) {
			this.node = node;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(5);
		root.left.right.right.right = new TreeNode(6);

		TreeNode temp = root;
		getTopView(temp);

		// for bottom view , keep updating the map if key exists
	}

	private static void getTopView(TreeNode temp) {
		if (temp == null) {
			return;
		}

		Map<Integer, Integer> hash = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(temp, 0));
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			TreeNode curr = p.node;
			int d = p.val;
			min = Math.min(min, d);
			max = Math.max(max, d);
			// ArrayList<Integer>
			if (!hash.containsKey(d)) {
				hash.put(d, curr.data);
			}
			if (curr.left != null) {
				q.add(new Pair(curr.left, d - 1));
			}
			if (curr.right != null) {
				q.add(new Pair(curr.right, d + 1));
			}
		}
		System.out.println(hash);
//
		ArrayList<Integer> ans = new ArrayList<>();
//		
		for (int i = min; i <= max; i++) {
			System.out.println(i + " : " + hash.get(i));
		}

//		Set<Integer> a = hash.keySet();
//		
//		for(int i : a) {
//			System.out.println(i);
//		}

		for (Entry<Integer, Integer> ele : hash.entrySet()) {
			ans.add(ele.getValue());
		}
		System.out.println(ans);

	}

}
//		for (Map.Entry<Integer, Node> entry :
//			topViewMap.entrySet()) {
//			System.out.print(entry.getValue().data);
//		}
