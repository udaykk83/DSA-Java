package matrix;

import java.util.Arrays;

public class Rotate_Matrix_By_90_Degrees_In_A_Clockwise_Direction {

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotate90DegreeCW(mat);
		if (mat != null && mat.length > 0) {
			for (var r : mat) {
				System.out.println(Arrays.toString(r));
			}
		}

	}

	private static void rotate90DegreeCW(int[][] mat) {
		for (var ar : mat) {
			System.out.println(Arrays.toString(ar));
		}
		transposeMatrix(mat);
		int r = mat.length, c = mat[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c / 2; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[i][c - j - 1];
				mat[i][c - j - 1] = temp;
			}
		}
	}

	private static void transposeMatrix(int[][] mat) {
		int r = mat.length, c = mat[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = i; j < c; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}

	}

}
