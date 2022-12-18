package dp;

public class Unique_Paths {

	public static void main(String[] args) {
		int r = 3, c = 7;
		int ways[][] = new int[r][c];
		System.out.println(findPathsByRecursion(ways, r - 1, c - 1));
		System.out.println(findPathsbyDP(r, c));
	}

	private static int findPathsbyDP(int r, int c) {
		if (r == 1 && c == 1) {
			return 1;
		}
		// ways indicates the no of ways to reach the i, j from starting point
		int ways[][] = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i == 0 && j == 0) {
					ways[i][j] = 0;
				} else if (i == 0 || j == 0) {
					ways[i][j] = 1;
				} else {
					ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
				}
			}
		}
		return ways[r - 1][c - 1];
	}

	private static int findPathsByRecursion(int ways[][], int r, int c) {
//		System.out.println(r + " and c "+ c);
		if (r == 0 && c == 0) {
			return 0;
		}
		if (r == 0 || c == 0) {
			return 1;
		}
		ways[r][c] = findPathsByRecursion(ways, r - 1, c) + findPathsByRecursion(ways, r, c - 1);
		return ways[r][c];
	}

}
