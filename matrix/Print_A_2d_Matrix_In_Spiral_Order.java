package matrix;

import java.util.ArrayList;

public class Print_A_2d_Matrix_In_Spiral_Order {

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4, 5 }, { 16, 17, 18, 19, 6 }, { 15, 24, 25, 20, 7 }, { 14, 23, 22, 21, 8 },
				{ 13, 12, 11, 10, 9 } };
		ArrayList<Integer> ans = new ArrayList<>();
		getElementsInSpiralOrder(mat, ans);
		System.out.println(ans);
	}

	public static void getElementsInSpiralOrder(int[][] mat, ArrayList<Integer> ans) {
		int top = 0, left = 0;
		int bottom = mat.length - 1, right = mat[0].length - 1;
		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++) {
				ans.add(mat[top][i]);
			}
			top++;
			for (int i = top; i <= bottom; i++) {
				ans.add(mat[i][right]);
			}
			right--;
			for (int i = right; i >= left; i--) {
				ans.add(mat[bottom][i]);
			}
			bottom--;
			for (int i = bottom; i >= top; i--) {
				ans.add(mat[i][left]);
			}
			left++;
		}
	}
}
