package searching;

class Maximum_Subarray_Size_All_Subarrays_Of__Size_Have_Sum_Less_Than_KSol {

	public void findKByBinarySearchApproach(int[] arr, int k) {
		int n = arr.length;
		int l = 1, r = n;
		int ans = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (isSumLessThanKForSizeMid(arr, k, mid)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		System.out.println(ans);
	}

	private boolean isSumLessThanKForSizeMid(int[] arr, int k, int mid) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < mid; i++) {
			sum += arr[i];
		}
		if (sum > k) {
			return false;
		}
		for (int i = mid; i < n; i++) {
			sum = sum + arr[i] - arr[i - mid];
			if (sum > k) {
				return false;
			}
		}
		return true;
	}

}

//Brute Force, would be to take iterate over all sub-array sizes 
//And keep checking if sum <= k, and keep storing the max answer in all the sub arrays.

//TC o(NlogN)
public class Maximum_Subarray_Size_All_Subarrays_Of__Size_Have_Sum_Less_Than_K {

	public static void main(String[] args) {
		Maximum_Subarray_Size_All_Subarrays_Of__Size_Have_Sum_Less_Than_KSol sol = new Maximum_Subarray_Size_All_Subarrays_Of__Size_Have_Sum_Less_Than_KSol();
//		int arr[] = { 1, 2, 3, 4 };
//		int k = 8;
		int arr[] = { 1, 2, 10, 4 }, k = 14;
		sol.findKByBinarySearchApproach(arr, k);
	}

}
