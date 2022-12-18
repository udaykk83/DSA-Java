package dp.stocks;

public class I_Buy_And_Sell_Stock {

	public static void main(String[] args) {
		int prices[] = { 7, 1, 5, 3, 6, 4 };
		int ans = 0;
		int n = prices.length;
		int min = prices[0];
		for (int i = 1; i < n; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				ans = Math.max(ans, prices[i] - min);
			}
		}
		System.out.println(ans);
	}

}	
