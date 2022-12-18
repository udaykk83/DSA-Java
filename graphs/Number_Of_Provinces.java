package graphs;

import java.util.*;

public class Number_Of_Provinces {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();

		input.add(new ArrayList<Integer>());
		input.get(0).add(0, 1);
		input.get(0).add(1, 0);
		input.get(0).add(2, 1);
		input.add(new ArrayList<Integer>());
		input.get(1).add(0, 0);
		input.get(1).add(1, 1);
		input.get(1).add(2, 0);
		input.add(new ArrayList<Integer>());
		input.get(2).add(0, 1);
		input.get(2).add(1, 0);
		input.get(2).add(2, 1);

		findCountOfProvinces(input, input.size());
	}

	private static void findCountOfProvinces(ArrayList<ArrayList<Integer>> input, int size) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < size; i++) {
			adj.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i != j && input.get(i).get(j) == 1) {
					adj.get(i).add(j);
					adj.get(j).add(i);
				}
			}
		}

		boolean vis[] = new boolean[size + 1];
		int cnt = 0;

		for (int i = 0; i < size; i++) {
			if (vis[i] == false) {
				cnt++;
				DFSHelper(i, adj, vis);
			}
		}
		System.out.println("\ncount is " + cnt);

	}

	private static void DFSHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
		vis[node] = true;
		System.out.print(node + " - ");
		for (int edge : adj.get(node)) {
			if (vis[edge] == false) {
				DFSHelper(edge, adj, vis);
			}
		}

	}

}
