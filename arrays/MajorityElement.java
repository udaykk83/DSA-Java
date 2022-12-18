package arrays;

class MajorityElementSol {

	private boolean isMajority(int[] arr, int res) {
		int n = arr.length;
		int c = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == res) {
				c++;
			}
		}
		return c > n / 2 ? true : false;
	}

	public int findN_2Element(int[] arr) {
		int n = arr.length;
		int num = Integer.MIN_VALUE;
		int cnt = 0;
		for (int val : arr) {
			if (val == num) {
				cnt++;
			} else if (cnt == 0) {
				num = val;
				cnt++;
			} else {
				cnt--;
			}

		}
		System.out.println(isMajority(arr, num));
		return num;
	}

	public int findN_3Element(int[] arr) {
		int n = arr.length;
		int cnt1 = 0, cnt2 = 0;
		int num1 = Integer.MIN_VALUE, num2 = Integer.MIN_VALUE;
		for (int val : arr) {
			if (val == num1) {
				cnt1++;
			} else if (val == num2) {
				cnt2++;
			} else if (cnt1 == 0) {
				num1 = val;
				cnt1++;
			} else if (cnt2 == 0) {
				num2 = val;
				cnt2++;
			} else {
				cnt1--;
				cnt2--;
			}
		}
		System.out.println(num1 + " n/3 " + num2);
		int c1 = 0, c2 = 0;
		for (int i = 0; i < n; i++) {
			if (num1 == arr[i]) {
				c1++;
			} else if (num2 == arr[i]) {
				c2++;
			}
		}
		return c1 > n / 3 ? num1 : c2 > n / 3 ? num2 : -1;
	}

}

public class MajorityElement {

	public static void main(String[] args) {
		MajorityElementSol p = new MajorityElementSol();
		int arr[] = new int[] { 2, 2, 1, 1, 1, 2, 2,1 };
		System.out.println(p.findN_2Element(arr));
		System.out.println(p.findN_3Element(arr));
	}

}
