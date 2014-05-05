import java.util.ArrayList;
import java.util.Scanner;


public class Candy {
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        ArrayList<Integer> dp = new ArrayList<Integer>();
        for (int i = 0; i < ratings.length; i++) {
            dp.add(i, 1);
        }

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp.set(i, dp.get(i - 1) + 1);
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && dp.get(i) <= dp.get(i + 1)) {
                dp.set(i, dp.get(i + 1) + 1);
            }
        }

        int res = 0;

        for (int i = 0; i < dp.size(); i++) {
            res += dp.get(i);
        }

        return res;
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] ratings = new int[n];
            for (int i = 0; i < n; i++) {
                ratings[i] = cin.nextInt();
            }

            int res = candy(ratings);

            System.out.println(res);
        }

        cin.close();
    }
}
