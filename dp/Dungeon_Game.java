package dp;

public class Dungeon_Game {

	public static void main(String[] args) {
		int[][] dun = new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(calculateMinimumHP(dun));
	}

	public static int calculateMinimumHP(int[][] dun) {
		int r = dun.length;
		int c = dun[0].length;

		int health[][] = new int[r][c];

		for (int i = r - 1; i >= 0; i--) {
			for (int j = c - 1; j >= 0; j--) {
				if (i == r - 1 && j == c - 1) {
					if (dun[i][j] < 0) {
						health[i][j] = Math.abs(dun[i][j]) + 1;
					} else {
						health[i][j] = 1;
					}
				} else if (j == c - 1) {
					// if we don't have enough health, we add the diff
					if (dun[i][j] < health[i + 1][j]) {
						health[i][j] = health[i + 1][j] - dun[i][j];
					} else {
						// or else, we add the bare min to enter the positive cell
						health[i][j] = 1;
					}
				} else if (i == r - 1) {
					if (dun[i][j] < health[i][j + 1]) {
						health[i][j] = health[i][j + 1] - dun[i][j];
					} else {
						health[i][j] = 1;
					}
				} else {
					int h = Math.min(health[i + 1][j], health[i][j + 1]);
					if (dun[i][j] < h) {
						health[i][j] = h - dun[i][j];
					} else {
						health[i][j] = 1;
					}
				}
			}
		}
		return health[0][0];
	}

// [[-10]]: ans  = 1 + (-(-10)) = 11 (explanation to first point mentioned)
// [[10]] : ans  = 1 as we still need 1 health at first place to get there (explanation to second point mentioned)
// [[-2,-3,3,-5,-10]]: ans = 1 + (-(-17)) = 18 same as 1st case
// [[2,3,3,5,10]]: ans = 1 same as 2nd test case, explanation to second point mentioned to asking question
// min health required to reach that particular cell
// if health is already positive, still we need 1 health
}
