import java.util.Scanner;


public class JumpGame {
    public static boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        boolean flag = true;
        int dp[] = new int[A.length];
        dp[0] = 1;
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            if (dp[i] == 0) {
                flag = false;
                break;
            } else {
                int tmp = i + A[i];
                if (tmp > max) {
                    for (int j = max; j < A.length && j <= tmp; j++) {
                        dp[j] = 1;
                    }
                    max = tmp;
                }
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int A[] = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = cin.nextInt();
            }

            boolean flag = canJump(A);

            System.out.println(flag);
        }

        cin.close();
    }
}
