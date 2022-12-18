package recursion;

public class Unique_Paths_III {

	static int ans = 0;
	static int zero_count = 1;

	public static int uniquePathsIII(int[][] grid) {
		ans = 0;
		int si = 0, sj = 0;
		int ei = 0, ej = 0;
		int nr = grid.length;
		int nc = grid[0].length;
		zero_count = 0;
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (grid[i][j] == 1) {
					si = i;
					sj = j;
				} else if (grid[i][j] == 0) {
					zero_count++;
				}
			}
		}
		// System.out.println(zero_count);
		findTotalPathsCount(grid, si, sj, 0);
		return ans;
	}

	static int[][] ways = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static boolean isValidCell(int[][] grid, int r, int c) {
		int nr = grid.length;
		int nc = grid[0].length;
		return r < nr && r >= 0 && c < nc && c >= 0 && grid[r][c] != -1;
	}

	public static void findTotalPathsCount(int[][] grid, int r, int c, int cnt) {
		// check for valid cell
		if (!isValidCell(grid, r, c)) {
			// System.out.println(" -- "+ r +" "+ c);
			return;
		}
		// check for end point and zero count
		if (grid[r][c] == 2) {
			// as the dest is 2, in rec zero was sent as cnt+1, so cnt-1 is being done
			if (zero_count == cnt - 1) {
//				System.out.println(zero_count + " - " + cnt);
				ans++;
			}
			return;
		}
		// mark as visited
		grid[r][c] = -1;
		for (int w = 0; w < ways.length; w++) {
			findTotalPathsCount(grid, r + ways[w][0], c + ways[w][1], cnt + 1);
		}
		// backtrack with 0, as route is not found
		grid[r][c] = 0;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
		System.out.println(uniquePathsIII(grid));

	}

}