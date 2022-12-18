package searching;

import java.util.Arrays;

class Aggressive_CowsSol {

	public void findMinDistanceBetweenCows(int[] stalls, int noOfCows) {
		int high = Integer.MIN_VALUE;
		int low = Integer.MAX_VALUE;
		for (int val : stalls) {
			low = Math.min(low, val);
			high = Math.max(high, val);
		}
		int ans = -1;
		int l = 1, r = high - low;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (checkIfPossibleAtMidDistance(stalls, mid, noOfCows)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		System.out.println(ans);
	}

	private boolean checkIfPossibleAtMidDistance(int[] stalls, int mid, int noOfCows) {
		int prevCowPos = stalls[0];
		int cnt = 1;
		for (int i = 1; i < stalls.length; i++) {
			if (stalls[i] - prevCowPos >= mid) {
				prevCowPos = stalls[i];
				cnt++;
			}
		}
		if (cnt >= noOfCows)
			return true;
		else
			return false;
	}

}

public class Aggressive_Cows_Max_Distance {

	public static void main(String[] args) {
		Aggressive_CowsSol sol = new Aggressive_CowsSol();
		int stalls[] = { 1, 2, 8, 4, 9 };
		Arrays.sort(stalls);
		int noOfCows = 3;
		sol.findMinDistanceBetweenCows(stalls, noOfCows);
	}

}
