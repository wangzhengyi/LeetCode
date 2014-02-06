import java.util.ArrayList;


public class PermutationsII {
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }

        permuteUnique(0, num.length - 1, num, res);

        return res;
    }

    public static void permuteUnique(int bt, int ed, int[] num, ArrayList<ArrayList<Integer>> res) {
        if (bt == ed) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < num.length; i++) {
                tmp.add(num[i]);
            }
            res.add(tmp);
        } else {
            for (int i = bt; i <= ed; i++) {
                if (shouldSwap(num, bt, i)) {
                    swap(bt, i, num);
                    permuteUnique(bt + 1, ed, num, res);
                    swap(bt, i, num);
                }
            }
        }
    }

    public static boolean shouldSwap(int[] num, int bt, int k) {
        boolean flag = true;

        for (int i = bt; i < k; i++) {
            if (num[i] == num[k]) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static void swap(int i, int j, int[] num) {
        if (i != j) {
            num[i] = num[i] ^ num[j];
            num[j] = num[i] ^ num[j];
            num[i] = num[i] ^ num[j];
        }
    }
}
