package searching;

class Find_The_First_Occurrence_Of_Number_In_A_Sorted_ArraySol {

	public int findFirstOccur(int[] arr, int k) {

		int n = arr.length;
		int l = 0, r = n - 1;
		int ans = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			// Move towards left for first occur, and store meanwhile to track any found
			if (arr[mid] == k) {
				ans = mid;
				r = mid - 1;
			} else if (arr[mid] < k) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return ans;
	}

}

public class Find_The_First_Occurrence_Of_Number_In_A_Sorted_Array {

	public static void main(String[] args) {
		Find_The_First_Occurrence_Of_Number_In_A_Sorted_ArraySol sol = new Find_The_First_Occurrence_Of_Number_In_A_Sorted_ArraySol();
		int arr[] = { 2, 55, 755, 25, 6, 6, 8, 9, 9, 9 };
		int k = 6;
		System.out.println(sol.findFirstOccur(arr, k));
	}

}
