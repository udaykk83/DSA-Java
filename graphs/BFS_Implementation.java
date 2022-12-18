package graphs;

import java.util.*;

public class BFS_Implementation {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(4);
		adj.get(4).add(0);
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(1).add(3);
		adj.get(3).add(1);
		BFSTraversal(adj, 5);
	}

	private static void BFSTraversal(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean vis[] = new boolean[V];
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		q.add(0);
		vis[0] = true;

		while (!q.isEmpty()) {
			int temp = q.poll();
			ans.add(temp+1);
			for (Integer node : adj.get(temp)) {
				if (vis[node] == false) {
					vis[node] = true;
					q.add(node);
				}
			}
		}
		System.out.println(ans);

	}

}
