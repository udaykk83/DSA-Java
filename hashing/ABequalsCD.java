package hashing;

import java.util.*;

class Pair {
	int l, r;

	Pair(int l, int r) {
		this.l = l;
		this.r = r;
	}
}

class Solution {
	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	public void checkIfExistsSum(int[] arr) {
		HashMap<Integer, Pair> hash = new HashMap<>();
		int n = arr.length;
		int c = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = arr[i] + arr[j];
				if (hash.containsKey(sum)) {
					Pair p = hash.get(sum);
					int x = p.l;
					int y = p.r;
					if (i != x && i != y && j != x && j != y) {
						c++;
						System.out.println(arr[i] + " j " + arr[j] + " x " + arr[x] + " y " + arr[y]);
						list.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[x], arr[y])));
					}
				} else {
					Pair pp = new Pair(i, j);
					hash.put(sum, pp);
				}
			}
		}
		System.out.println(c + "no result");
		return;
	}

}

public class ABequalsCD {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = { 7, 3, 2, 8, 12, 1, 5, 4 };
		s.checkIfExistsSum(arr);
	}

}
