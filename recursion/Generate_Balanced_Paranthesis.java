package recursion;

import java.util.*;

public class Generate_Balanced_Paranthesis {

	public static void main(String[] args) {
		int n = 3;

		int open = n;
		int closed = n;
		generateBalancedParenthesis(open, closed, "");
		System.out.println(ans);

	}

	static List<String> ans = new ArrayList<>();

	private static void generateBalancedParenthesis(int open, int closed, String output) {
		if (open == 0 && closed == 0) {
			ans.add(output);
			return;
		}
		if (open > 0) {
			generateBalancedParenthesis(open - 1, closed, output + "(");
		}
		if (closed > open) {
			generateBalancedParenthesis(open, closed - 1, output + ")");
		}
	}

}
