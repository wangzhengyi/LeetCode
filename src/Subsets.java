import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Subsets {
    public static void main(String args[]) {
        int i, n, S[];
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();
            S = new int[n];

            for (i = 0; i < n; i++) {
                S[i] = cin.nextInt();
            }

            ArrayList<ArrayList<Integer>> res = subsets(S);

            for (int j = 0; j < res.size(); j++) {
                for (int k = 0; k < res.get(j).size(); k++) {
                    System.out.printf("%d ", res.get(j).get(k));
                }
                System.out.println();
            }
        }

        cin.close();
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.length == 0) {
            return res;
        }

        // ascend
        Arrays.sort(S);

        int max = 1 << S.length;

        for (int i = 0; i < max; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            int j = i;

            for (int index = 0; j > 0; j >>= 1, index++) {
                if ((j & 1) == 1) {
                    tmp.add(S[index]);
                }
            }

            res.add(tmp);
        }

        return res;
    }
}
