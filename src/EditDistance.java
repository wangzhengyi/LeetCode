public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int lenStr1 = word1.length();
        int lenStr2 = word2.length();
        int[][] dp = new int[lenStr1 + 1][lenStr2 + 1];

        // initialize the dynamic program array
        for (int i = 0; i <= lenStr1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= lenStr2; j++) {
            dp[0][j] = j;
        }

        // dynamic programming
        for (int i = 1; i <= lenStr1; i++) {
            for (int j = 1; j <= lenStr2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int min = Math.min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1);
                    min = Math.min(min, dp[i][j - 1] + 1);
                    dp[i][j] = min;
                }
            }
        }

        return dp[lenStr1][lenStr2];
    }
}
