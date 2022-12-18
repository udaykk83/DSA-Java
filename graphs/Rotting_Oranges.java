package graphs;

import java.util.*;

public class Rotting_Oranges {

	public static void main(String[] args) {
		int grid[][] = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(orangesRotting(grid));

	}

	static int dir[][] = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static boolean isValidFreshOrangeCell(int i, int j, int m, int n) {
		return i >= 0 && i < m && j >= 0 && j < n;
	}

	public static int orangesRotting(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		boolean vis[][] = new boolean[m + 1][n + 1];

		Queue<int[]> q = new LinkedList<>();
		int totalOranges = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					q.add(new int[] { i, j });
					vis[i][j] = true;
				} else if (grid[i][j] == 1) {
					totalOranges++;
				}
			}
		}
		return bfsHelper(q, vis, totalOranges, grid, m, n);
	}

	public static int bfsHelper(Queue<int[]> q, boolean vis[][], int totalOranges, int[][] grid, int m, int n) {
		if (totalOranges == 0) {
			return 0;
		}
		int ans = 0;
		while (!q.isEmpty()) {
			ans++;
			int qSize = q.size();
			while (qSize > 0) {
				int[] cell = q.poll();
				System.out.println(cell[0] + "-" + cell[1]);
				for (int k = 0; k < 4; k++) {
					int i = cell[0] + dir[k][0];
					int j = cell[1] + dir[k][1];
					if (isValidFreshOrangeCell(i, j, m, n) && grid[i][j] == 1 && vis[i][j] == false) {
						q.add(new int[] { i, j });
						vis[i][j] = true;
						--totalOranges;
					}
				}
				qSize--;
			}
		}

		if (totalOranges == 0) {
			return ans - 1;
		} else {
			return -1;
		}
	}

}