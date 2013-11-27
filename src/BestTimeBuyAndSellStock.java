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

    public static int maxProfit2(int[] prices) {
        if (prices.length == 0) return 0;

        int i, income;

        for (i = 0, income = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                income += prices[i + 1] - prices[i];
            }
        }

        return income;
    }

    public static int maxProfit3(int[] prices) {
        if (prices.length == 0) return 0;

        int i, j, tmp, dp[][] = new int[3][prices.length + 1];

        // 初始化dp数组
        for (i = 0; i < 3; i++) {
            dp[i][0] = 0;
        }

        for (i = 0; i < prices.length + 1; i++) {
            dp[0][i] = 0;
        }

        // 动态规划dp[i][j] = max{dp[i - 1][j], dp[i - 1][k] + prices[j] - prices[k](0 <= k < j)}
         for (i = 1; i < 3; i++) {
            tmp = dp[i - 1][0] - prices[0];
            for (j = 1; j < prices.length + 1; j++) {
                dp[i][j] = dp[i][j - 1];

                if (tmp + prices[j - 1] > dp[i][j]) dp[i][j] = tmp + prices[j - 1];

                if (tmp < dp[i - 1][j] - prices[j - 1]) tmp = dp[i - 1][j] - prices[j - 1];
            }
        }

        return dp[2][prices.length];
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
            // value = maxProfit1(prices);

            // Best Time to Buy and Sell Stock Two
            // value = maxProfit2(prices);

            // Best Time to Buy and Sell Stock Three
            value = maxProfit3(prices);

            System.out.println(value);
        }

        cin.close();
    }

}
