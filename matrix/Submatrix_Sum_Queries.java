package matrix;

import java.util.*;

//https://www.techiedelight.com/calculate-sum-elements-sub-matrix-constant-time/
class Submatrix_Sum_QueriesSol {

	public int[][] calculatePrefixArrayRowAndColumnWise(int[][] mat, int[][] prefix, int rowSize, int colSize) {
		// (0,0) done
		prefix[0][0] = mat[0][0];

		// First Row== 0, so iterate columns
		for (int i = 1; i < colSize; i++)
			prefix[0][i] = mat[0][i] + prefix[0][i - 1];
		// for first columns, iterate over rows
		for (int i = 1; i < rowSize; i++)
			prefix[i][0] = mat[i][0] + prefix[i - 1][0];

		for (int i = 1; i < rowSize; i++) {
			for (int j = 1; j < colSize; j++) {
				prefix[i][j] = mat[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
			}
		}
		for (var arr : prefix) {
			System.out.println(Arrays.toString(arr));
		}
		return prefix;
	}

	public void findSubMatrixSum(int[][] prefix, int i, int j, int k, int l) {
		int ans = prefix[k][l];

		if (i > 0) {
			ans = ans - prefix[i - 1][l];
		}
		if (j > 0) {
			ans = ans - prefix[k][j - 1];
		}
		if (i > 0 && j > 0) {
			ans = ans + prefix[i - 1][j - 1];
		}
		System.out.println("Sum is " + ans);
	}
}

public class Submatrix_Sum_Queries {

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4, 6 }, { 5, 3, 8, 1, 2 }, { 4, 6, 7, 5, 5 }, { 2, 4, 8, 9, 4 } };
		for (var arr : mat) {
			Arrays.sort(arr);
			System.out.println(Arrays.toString(arr));
		}

		System.out.println();
		Submatrix_Sum_QueriesSol p = new Submatrix_Sum_QueriesSol();
		int rowSize = mat.length, colSize = mat[0].length;
		int prefix[][] = new int[rowSize][colSize];
		prefix = p.calculatePrefixArrayRowAndColumnWise(mat, prefix, rowSize, colSize);
		p.findSubMatrixSum(prefix, 01, 01, 2, 2);

	}

}
