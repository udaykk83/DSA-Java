package searching;

/*
   /
  /| 
 / |
/  |
   |    /
   |   /
   |  /
   | / 
   |/  
s;(m,m+1);e
*/
   
class Search_An_Element_In_A_Circularly_Sorted_ArraySol {

	public void findPivotElement(int[] arr, int k) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int pivot = -1;
		if (arr[0] > arr[n - 1]) {
			pivot = findPivot(arr, k, n);
		}
		// normal total binary search, as array is sorted completely
		int ans = -1;
		if (pivot == -1) {
			ans = binarySearch(arr, 0, n - 1, k);
			System.out.println(ans);
			return;
		} else if (arr[pivot] == k) {
			ans = pivot;
		} else if (arr[0] <= k) {
			ans = binarySearch(arr, 0, pivot - 1, k);
		} else {
			ans = binarySearch(arr, pivot + 1, n - 1, k);
		}
		System.out.println("pivot " + pivot + " pivot no is " + arr[pivot] + " and no. index is " + ans);
	}

	private int findPivot(int[] arr, int k, int n) {
		int l = 0;
		int r = n - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] > arr[mid + 1]) {
				return mid + 1;
			} else {
				if (arr[l] > arr[mid]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
		}
		return -1;
	}

	private int binarySearch(int[] arr, int l, int r, int k) {
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == k) {
				return mid;
			} else if (arr[mid] < k) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

}

public class Search_An_Element_In_A_Circularly_Sorted_Array {

	public static void main(String[] args) {
		int[] arr = { 9, 10, 12, 15, 6, 8 };
		// { 9, 10, 12, 15, 6, 8 } pivot is 6 . 
		int k = 190;
		Search_An_Element_In_A_Circularly_Sorted_ArraySol sol = new Search_An_Element_In_A_Circularly_Sorted_ArraySol();
		sol.findPivotElement(arr, k);
	}

}
