package searching;

class Allocate_Minimum_Number_Of_PagesSol {

	public void findMinPossibleMaxAnswer(int[] arr, int students) {
		int n = arr.length;
		int l = arr[0], r = 0;
		for (int val : arr) {
			l = Math.max(l, val);
			r = r + val;
		}
		int ans = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			System.out.println("low " + l + " high " + r + " mid " + mid);
			if (isPossible(arr, students, mid)) {
				ans = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		System.out.println(ans);
	}

	private boolean isPossible(int[] arr, int students, int maxPages) {
		int cntOfStudents = 1;
		int sum = 0;
		// We can't allocate more than maxPages for a student, utmost maxPages
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (sum > maxPages) {
				sum = arr[i];
				cntOfStudents++;
			}
		}
		// by the allocation, if cntOfStudents is more than students,
		// then return false,As it is not possible
		// So increase maxPages
		return cntOfStudents <= students ? true : false;
	}

}

//Minimize the max pages
public class Allocate_Minimum_Number_Of_Pages {

	public static void main(String[] args) {
		Allocate_Minimum_Number_Of_PagesSol sol = new Allocate_Minimum_Number_Of_PagesSol();
		int arr[] = { 12, 34, 67, 90 };
		int students = 2;
		sol.findMinPossibleMaxAnswer(arr, students);

	}

}
