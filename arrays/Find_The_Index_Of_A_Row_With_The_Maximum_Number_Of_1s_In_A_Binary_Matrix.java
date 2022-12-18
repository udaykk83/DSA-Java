package arrays;

public class Find_The_Index_Of_A_Row_With_The_Maximum_Number_Of_1s_In_A_Binary_Matrix {

	public static void main(String[] args) {
		int[][] mat = { { 0, 0, 0, 1, 1 },
				{ 0, 1, 1, 1, 1 }, 
				{ 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 1 }
				};
		int a = findMaxRow(mat);
		System.out.println(a);
	}

	private static int findMaxRow(int[][] mat) {
		int i = 0, j = mat[0].length - 1;
		int r = mat.length - 1;
		int ans = Integer.MIN_VALUE;
		while (i <= r && j >= 0) {
			if (mat[i][j] == 1) {
				j--;
				ans = Math.max(i, ans);
			} else {
				i++;
			}

		}
		//convert from array to normal
		return ans+1;
	}

}
