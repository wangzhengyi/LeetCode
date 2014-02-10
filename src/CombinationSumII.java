import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class CombinationSumII {
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();

        if (num == null || num.length == 0) {
            return res;
        }

        Arrays.sort(num);

        depthFirstSearch(0, target, 0, num, tmp, res);

        return res;
    }

    public static void depthFirstSearch(int sum, int target, int pos, int[] num,
            ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(tmp));
        } else {
            for (int i = pos; i < num.length;) {
                if (sum + num[i] <= target) {
                    tmp.add(num[i]);
                    depthFirstSearch(sum + num[i], target, i + 1, num, tmp, res);
                    tmp.remove(tmp.size() - 1);
                }

                int j = i + 1;
                while (j < num.length && num[j] == num[i]) {
                    j++;
                }

                i = j;
            }
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int target = cin.nextInt();
            int[] num = new int[n];

            for (int i = 0; i < n; i++) {
                num[i] = cin.nextInt();
            }

            ArrayList<ArrayList<Integer>> res = combinationSum2(num, target);

            System.out.println(res);
        }

        cin.close();
    }
}
