import java.util.Scanner;

public class BestTimeBuyAndSellStock {
    public static int maxProfit1(int[] prices) {
        if (prices.length == 0) return 0;

        int i, income, min, diff;

        for (income = 0, min = prices[0], i = 1; i < prices.length; i++) {
            diff = prices[i] - min;

            if (diff > income) income = diff;

            if (prices[i] < min) min = prices[i];
        }

        return income;
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int i, n, value, prices[];

        while (cin.hasNext()) {
            n = cin.nextInt();
            prices = new int[n];

            for (i = 0; i < n; i++) {
                prices[i] = cin.nextInt();
            }

            // Best Time to Buy and Sell Stock One
            value = maxProfit1(prices);
            System.out.println(value);
        }

        cin.close();
    }

}
