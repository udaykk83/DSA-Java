package recursion;

public class Permutations_Of_A_String {

	public static void main(String[] args) {
		String str = "abc";
		int idx = 0;
		generatePermutations(str, idx, str.length());
	}

	private static void generatePermutations(String str, int idx, int n) {
		if (idx == n) {
			System.out.println(str);
			return;
		}
		for (int i = idx; i < n; i++) {
			str = swap(str, i, 	idx);
			generatePermutations(str, idx + 1, n);
			str = swap(str, i, idx);
		}
	}

	private static String swap(String str, int i, int idx) {
		char ch[] = str.toCharArray();
		char temp = ch[i];
		ch[i] = ch[idx];
		ch[idx] = temp;
		return new String(ch);
	}

}
