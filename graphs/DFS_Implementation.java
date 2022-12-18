package graphs;

import java.util.*;

public class DFS_Implementation {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(3);
		adj.get(3).add(0);
		adj.get(2).add(4);
		adj.get(4).add(2);
		DFSTraversal(adj, 5);
	}

	private static void DFSTraversal(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean vis[] = new boolean[V];
		ArrayList<Integer> ans = new ArrayList<>();
		int node = 0;
		DFSHelper(node, adj, vis, ans);

		System.out.println(ans);

	}

	private static void DFSHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
		vis[node] = true;
		ans.add(node + 1);

		for (int edge : adj.get(node)) {
			if (vis[edge] == false) {
				DFSHelper(edge, adj, vis, ans);
			}
		}

	}

}
