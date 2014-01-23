import java.util.ArrayList;
import java.util.Scanner;


public class Triangle {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
            int n = cin.nextInt();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                int m = cin.nextInt();
                for (int j = 0; j < m; j++) {
                    tmp.add(cin.nextInt());
                }
                triangle.add(tmp);
            }

            int min = minimumTotal(triangle);

            System.out.println(min);
        }

        cin.close();
    }

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int i, j, len, n, min, dp[];

        n = triangle.size();
        len = triangle.get(n - 1).size();
        dp = new int[len];

        for (i = 0; i < n; i++) {
            for (j = triangle.get(i).size() - 1; j >= 0; j--) {
                if (j - 1 < 0) {
                    dp[j] = triangle.get(i).get(j) + dp[j];
                } else if (j == triangle.get(i).size() - 1) {
                    dp[j] = triangle.get(i).get(j) + dp[j - 1];
                } else {
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j - 1], dp[j]);
                }
            }
        }

        for (i = 0, min = Integer.MAX_VALUE; i < len; i++) {
            if (min > dp[i]) {
                min = dp[i];
            }
        }

        return min;
    }
}
