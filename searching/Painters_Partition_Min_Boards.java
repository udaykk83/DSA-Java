package searching;

class Painters_Partition_Min_BoardsSol {

	public void findMinTime(int[] boards, int painters) {
		int n = boards.length;
		int l = Integer.MIN_VALUE;
		int r = 0;
		for (int val : boards) {
			l = Math.max(l, val);
			r += val;
		}
		int ans = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (isPossibleToPaintByAtmostMidTime(boards, painters, mid)) {
				ans = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		System.out.println(ans);
	}

	private boolean isPossibleToPaintByAtmostMidTime(int[] boards, int painters, int mid) {
		int cntPainters = 1;
		int sum = 0;
		for (int i = 0; i < boards.length; i++) {
			sum = sum + boards[i];
			if (sum > mid) {
				cntPainters++;
				sum = boards[i];
			}
		}
		if (cntPainters <= painters) {
			return true;
		} else {
			return false;
		}
	}

}

//We have to paint n boards of length {A1, A2…An}.
//There are k painters available and each takes 1 unit time to paint 1 unit of board.
//The problem is to find the minimum time to get this job done.

public class Painters_Partition_Min_Boards {

	public static void main(String[] args) {
		Painters_Partition_Min_BoardsSol sol = new Painters_Partition_Min_BoardsSol();
		int painters = 10;
		int boards[] = { 1, 8, 11, 3 };
		sol.findMinTime(boards, painters);

	}

}
