package hashing;

import java.util.*;

class Soll {

	public ArrayList<Integer> findEquilibriumIndex(int[] a) {
		ArrayList<Integer> ans = new ArrayList<>();
		int n = a.length;
		int[] pre = new int[n];
		int[] suf = new int[n];
		pre[0] = a[0];
		suf[n - 1] = a[n - 1];

		for (int i = 1; i < n; i++) {
			pre[i] = pre[i - 1] + a[i];
		}
		for (int i = n - 2; i >= 0; i--) {
			suf[i] = suf[i + 1] + a[i];
		}
		for (int i = 0; i < n; i++) {
			if (pre[i] == suf[i])
				ans.add(a[i]);
		}
		return ans;
	}

	public ArrayList<Integer> OptimalSol(int[] arr) {
		ArrayList<Integer> ans = new ArrayList<>();
		int n = arr.length, sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		int left_sum = 0;
		int right_sum = sum;
		for(int i=0; i<n; i++) {
			right_sum -= arr[i];
			if(left_sum == right_sum) {
				ans.add(arr[i]);
			}
			left_sum += arr[i];
		}
		return ans;
	}

}

public class Find_Equilibrium_Index_Of_An_Array {

	public static void main(String[] args) {
		int[] A = { -7, 1, 5, 2, -4, 3, 0 };
		Soll s = new Soll();
		System.out.println(s.findEquilibriumIndex(A));
		System.out.println(s.OptimalSol(A));
	}

}
