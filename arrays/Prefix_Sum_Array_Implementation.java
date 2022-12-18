package arrays;

import java.util.*;

class PASSol {

	public int[] calculatePrefixArray(int[] arr) {
		
		int n = arr.length;
		int pre[] = new int[n+2];
		pre[0] = 0;
		for(int i=0; i<n; i++) {
			pre[i+1] = pre[i]+arr[i];
		}
		return pre;

	}

}

public class Prefix_Sum_Array_Implementation {

	public static void main(String[] args) {
		PASSol p = new PASSol();
		int arr[] = new int[] { 10, 20, 10, 5, 15 };
		int[] pre = p.calculatePrefixArray(arr);
		System.out.println(Arrays.toString(pre));
	}

}
