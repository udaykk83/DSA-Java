package recursion;

public class Print_All_Subsets {

	public static void main(String[] args) {
		String s = "abc";
		String op = "";
		generateSubsets(s, op);
		permutationWithSpaces(s, op, 0);
	}

	// use set, to remove duplicates, or consider only first letter for permutation
	private static void permutationWithSpaces(String s, String op, int index) {
		if (index == s.length()) {
			System.out.println(" -- " + op);
			return;
		}
		String op1, op2;
		if (index == 0) {
			op1 = op + s.charAt(index);
			op2 = op + s.charAt(index);
			// permutationWithSpaces(s, op1, index + 1);
		} else {
			// choices _ch or ch
			op1 = op + '_' + s.charAt(index);
			op2 = op + s.charAt(index);
			// permutationWithSpaces(s, op1, index + 1);
			// permutationWithSpaces(s, op2, index + 1);
		}
		permutationWithSpaces(s, op1, index + 1);
		permutationWithSpaces(s, op2, index + 1);

	}

	static int count = 0;

	private static void generateSubsets(String s, String op) {
		if (s == "") {
			System.out.println(count + " -- " + op);
			count++;
			return;
		}
		// Pick element
		String op1 = op + s.charAt(0);
		// Don't pick element
		String op2 = op;

		generateSubsets(s.substring(1), op1);
		generateSubsets(s.substring(1), op2);
	}

}
