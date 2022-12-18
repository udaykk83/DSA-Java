package twoPointers;

class Find_Subarray_With_Given_Sum_For_Positive_NumbersSol {

	public void findASubarrayByTwoPointers(int[] arr, int k) {
		int n = arr.length;
		if (n < 2)
			System.out.println("No/one element");
		int l = 0;
		int r = 1;
		int sum = arr[l];
		while (l <= r && r < n) {
			if (k == sum) {
				System.out.println(l + " to " + (r - 1));
				return;
			} else if(sum < k) {
				sum = sum + arr[r];
				r++;
			} else {
				sum = sum - arr[l];
				l++;
			}
		}
		System.out.println("Not found");
	}

}

public class Find_Subarray_With_Given_Sum_For_Positive_Numbers {

	public static void main(String[] args) {
		Find_Subarray_With_Given_Sum_For_Positive_NumbersSol sol = new Find_Subarray_With_Given_Sum_For_Positive_NumbersSol();
		int arr[] = new int[] {1, 4, 0, 0, 3, 10, 5};
		int k = 7;
		sol.findASubarrayByTwoPointers(arr, k);

	}

}
