package graphs;

public class Number_Of_Islands {

	public static void main(String[] args) {
		char[][] grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
		System.out.println(numIslands(grid));
	}

	static int dir[][] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int numIslands(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean vis[][] = new boolean[m + 1][n + 1];
		int ans = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1' && vis[i][j] == false) {
					ans++;
					DFSHelper(grid, vis, i, j);
				}
			}
		}
		return ans;
	}

	public static void DFSHelper(char[][] grid, boolean vis[][], int r, int c) {
		vis[r][c] = true;
		for (int k = 0; k < 4; k++) {
			int x = r + dir[k][0];
			int y = c + dir[k][1];
			if (isValidCell(grid, vis, x, y)) {
				if (vis[x][y] == false) {
					DFSHelper(grid, vis, x, y);
				}
			}
		}
	}

	public static boolean isValidCell(char[][] grid, boolean vis[][], int r, int c) {
		int m = grid.length;
		int n = grid[0].length;
		return r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1';
	}

}
