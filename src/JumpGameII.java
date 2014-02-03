import java.util.Scanner;


public class JumpGameII {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] A = new int[n];

            for (int i = 0; i < n; i++) {
                A[i] = cin.nextInt();
            }

            int step = jumpDp(A);

            System.out.println(step);

            step = jumpGreedy(A);

            System.out.println(step);
        }

        cin.close();
    }

    public static int jumpDp(int[] A) {
        int i, j, dp[] = new int[A.length];

        for (i = 0; i < dp.length; i++) {
            for (j = i + 1; j < dp.length && j <= i + A[i]; j++) {
                if (dp[j] == 0) {
                    dp[j] = dp[i] + 1;
                } else {
                    dp[j] = Math.min(dp[i] + 1, dp[j]);
                }
            }
        }

        return dp[A.length - 1];
    }

    public static int jumpGreedy(int[] A) {
        int start, end, max, step = 0;

        start = end = 0;

        while (end < A.length - 1) {
            step += 1;

            max = Integer.MIN_VALUE;

            for (int i = start; i <= end; i++) {
                if (A[i] + i >= A.length - 1) {
                    return step;
                }

                if (A[i] + i > max) {
                    max = A[i] + i;
                }
            }

            start = end + 1;
            end = max;
        }

        return step;
    }
}
