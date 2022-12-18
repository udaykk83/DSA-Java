package arrays;

import java.util.*;

class Find_Three_Closest_Elements_From_3_Sorted_ArraysSolution {

	public void findThreeELements(int[] a, int[] b, int[] c) {
		int na = a.length, nb = b.length, nc = c.length;
		int i = 0, j = 0, k = 0;
		int minDiff = Integer.MAX_VALUE;
		ArrayList<Integer> list = new ArrayList<>();
		while (i < na && j < nb && k < nc) {
			int min = Math.min(a[i], Math.min(b[j], c[k]));
			int max = Math.max(a[i], Math.max(b[j], c[k]));
			if (minDiff > max - min) {
				list.clear();
				list.add(a[i]);
				list.add(b[j]);
				list.add(c[k]);
				minDiff = max - min;
			}
			if (min == a[i]) {
				i++;
			} else if (min == b[j]) {
				j++;
			} else {
				k++;
			}
		}
		System.out.println(minDiff+" "+ list);

	}

}

//As diff = X-Y, trying to increase the Y value, so incrementing accordingly
public class Find_Three_Closest_Elements_From_3_Sorted_Arrays {

	public static void main(String[] args) {
		Find_Three_Closest_Elements_From_3_Sorted_ArraysSolution p = new Find_Three_Closest_Elements_From_3_Sorted_ArraysSolution();
		int A[] = { 3, 6, 8, 10, 15 };
		int B[] = { 1, 5, 12 };
		int C[] = { 4, 8, 15, 16 };
		p.findThreeELements(A, B, C);

	}

}
