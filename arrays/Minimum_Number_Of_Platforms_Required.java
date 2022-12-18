package arrays;

import java.util.Arrays;

class Minimum_Number_Of_Platforms_RequiredSol {

	public void findMinPlatforms(int[] arr, int[] dep) {
		int na = arr.length, nd = dep.length;
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		// Already a train present, so MIN One platform is needed
		int i = 1;
		int j = 0;
		int totalPlatforms = 1;
		int cnt = 1;
		while (i < na && j < nd) {
			// if a train is arriving, before leaving then we need to increase platform
			if (arr[i] < dep[j]) {
				cnt++;
				i++;
				totalPlatforms = Math.max(totalPlatforms, cnt);
			} else {
				cnt--;
				j++;
			}
		}
		
		System.out.println("totalPlatforms req = " + totalPlatforms);

	}

}

public class Minimum_Number_Of_Platforms_Required {

	public static void main(String[] args) {
		Minimum_Number_Of_Platforms_RequiredSol sol = new Minimum_Number_Of_Platforms_RequiredSol();
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		sol.findMinPlatforms(arr, dep);

	}

}
