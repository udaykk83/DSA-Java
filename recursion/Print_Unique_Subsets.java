package recursion;

import java.util.*;

public class Print_Unique_Subsets {

	public static void main(String[] args) {
		hashset.clear();
		// TODO Auto-generated method stub
		List<Integer> nums = Arrays.asList(1, 2, 4, 2);
		int idx = 0;
		List<Integer> ans = new ArrayList<>();
		getUniqueSubsets(nums, idx, "");
	}

	private static Set<String> hashset = new HashSet<>();

	private static void getUniqueSubsets(List<Integer> nums, int idx, String ans) {
		if (nums.size() == idx) {
			if (hashset.contains(ans) == false) {
				hashset.add(ans);
				System.out.println("-- " + ans);
			}
			return;
		}
		// pick
		getUniqueSubsets(nums, idx + 1, ans + String.valueOf(nums.get(idx)));
		// don't pick
		getUniqueSubsets(nums, idx + 1, ans);

	}

}
