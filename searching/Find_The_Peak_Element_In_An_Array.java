package searching;

class Find_The_Peak_Element_In_An_ArraySol {

	public int findPeakELement(int[] arr) {
		int n = arr.length;
		int l = 0;
		int r = n - 1;
		if (n == 1) {
			return arr[0];
		}
		if (arr[0] > arr[1]) {
			return arr[0];
		}
		if (arr[n - 1] > arr[n - 2]) {
			return arr[n - 1];
		}
		while (l <= r) {
			int mid = l + (r - l) / 2;
			// left most, right most and peak element
			if ((mid == 0 || arr[mid - 1] < arr[mid]) && (mid == n - 1 || arr[mid] > arr[mid + 1])) {
				return arr[mid];
			} else if (mid - 1 >= 0 && arr[mid - 1] > arr[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

}

public class Find_The_Peak_Element_In_An_Array {

	public static void main(String[] args) {
		Find_The_Peak_Element_In_An_ArraySol sol = new Find_The_Peak_Element_In_An_ArraySol();
		int[] arr = { 1, 3, 2, 4, 6, 0 };
		System.out.println(sol.findPeakELement(arr));

	}

}
