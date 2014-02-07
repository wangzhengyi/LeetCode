import java.util.ArrayList;
import java.util.Arrays;


public class SubSetsII {
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();

        Arrays.sort(num);

        res.add(tmp);

        dfs(0, num, tmp, res);

        return res;
    }

    public static void dfs(int pos, int[] num, ArrayList<Integer> tmp,
            ArrayList<ArrayList<Integer>> res) {
        if (pos >= num.length) {
            return;
        } else {
            for (int i = pos; i < num.length; i++) {
                tmp.add(num[i]);
                res.add(new ArrayList<Integer>(tmp));
                dfs(i + 1, num, tmp, res);
                tmp.remove(tmp.size() - 1);

                while (i + 1 < num.length && num[i] == num[i + 1]) {
                    i++;
                }
            }
        }
    }
}
