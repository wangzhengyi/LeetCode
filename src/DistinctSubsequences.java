import java.util.Scanner;

public class DistinctSubsequences {
    private static int disNum = 0;

    public static int numDistinctDfs(String S, String T) {
        int[] flags = new int[S.length()];
        int num = 0;

        dfs(num, flags, 0, 0, S, T);

        return disNum;
    }

    public static void dfs(int num, int[] flags, int indexS, int indexT, String S, String T) {
        if (num == T.length()) {
            disNum++;
        } else {
            for (int i = indexS; i < S.length(); i++) {
                if (S.charAt(i) == T.charAt(indexT) && flags[i] == 0) {
                    flags[i] = 1;
                    num++;
                    dfs(num, flags, i + 1, indexT + 1, S, T);
                    flags[i] = 0;
                    num--;
                }
            }
        }
    }

    public static int numDistinct(String S, String T) {
        if (S == null || S.length() == 0) {
            return 0;
        }

        int[][] dp = new int[T.length() + 1][S.length() + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= S.length(); i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= T.length(); i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= T.length(); i++) {
            for (int j = 1; j <= S.length(); j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[T.length()][S.length()];
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String S = cin.nextLine();
            String T = cin.nextLine();
            disNum = 0;

            int res = numDistinct(S, T);

            System.out.println(res);
        }

        cin.close();
    }
}
