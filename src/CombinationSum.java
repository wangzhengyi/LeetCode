import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class CombinationSum {
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        if (candidates == null || candidates.length == 0) {
            return list;
        }

        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        
        dfsCandidates(0, 0, target, candidates, tmp, list);

        return list;
    }

    public static void dfsCandidates(int index, int sum, int target, int[] candidates,
            ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> list) {
        if (sum == target) {
            list.add(new ArrayList<Integer>(tmp));
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (sum + candidates[i] <= target) {
                    tmp.add(candidates[i]);
                    dfsCandidates(i, sum + candidates[i], target, candidates, tmp, list);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int target = cin.nextInt();
            int candidates[] = new int[n];
            for (int i = 0; i < n; i++) {
                candidates[i] = cin.nextInt();
            }

            ArrayList<ArrayList<Integer>> list = combinationSum(candidates, target);

            System.out.println(list);
            
            for (ArrayList<Integer> tmp : list) {
                System.out.println(tmp);
            }
        }

        cin.close();
    }
}
