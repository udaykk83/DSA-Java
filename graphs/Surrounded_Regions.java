package graphs;

import java.util.*;

public class Surrounded_Regions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char board[][] = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		new Surrounded_Regions().findFinalRegion(board);
	}

	int dir[][] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public void findFinalRegion(char[][] board) {
		int m = board.length;
		int n = board[0].length;

		// first and last row
		for (int i = 0; i < n; i++) {
			if (board[0][i] == 'O') {
				DFSHelper(board, 0, i, 'Z');
			}
			if (board[m - 1][i] == 'O') {
				DFSHelper(board, m - 1, i, 'Z');
			}
		}
		for (char[] row : board) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("done rows");

		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				DFSHelper(board, i, 0, 'Z');
			}
			if (board[i][n - 1] == 'O') {
				DFSHelper(board, i, n - 1, 'Z');
			}
		}
		for (char[] row : board) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("done cols");

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					DFSHelper(board, i, j, 'X');
				}
			}
		}

		for (char[] row : board) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("done middle");

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'Z') {
					board[i][j] = 'O';
				}
			}
		}
		for (char[] row : board) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("done");
		return;
	}

	public void DFSHelper(char[][] board, int r, int c, char ch) {
		board[r][c] = ch;

		for (int k = 0; k < 4; k++) {
			int x = r + dir[k][0];
			int y = c + dir[k][1];
			if (isValidCell(board, x, y) && board[x][y] == 'O') {
				DFSHelper(board, x, y, ch);
			}
		}
	}

	public boolean isValidCell(char[][] board, int r, int c) {
		int m = board.length;
		int n = board[0].length;
		return r >= 0 && r < m && c >= 0 && c < n;
	}

}
