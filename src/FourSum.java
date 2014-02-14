import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class FourSum {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 4) {
            return res;
        }

        Arrays.sort(num);
        
        ArrayList<Integer> tmpStore = new ArrayList<Integer>();

        depthFS(0, 0, 0, num, target, tmpStore, res);

        return res;
    }

    public static void depthFS(int pos, int count, int sum, int[] num, int target,
            ArrayList<Integer> tmpStore, ArrayList<ArrayList<Integer>> res) {
        if (count == 4) {
            if (sum == target) {
                res.add(new ArrayList<Integer>(tmpStore));
            }
        } else {
            for (int i = pos; i < num.length && count < 4; i++) {
                if (sum + num[i] <= target) {
                    tmpStore.add(num[i]);
                    depthFS(i + 1, count + 1, sum + num[i], num, target, tmpStore, res);
                    tmpStore.remove(tmpStore.size() - 1);
                }
            }
        }
    }
    
    public static ArrayList<ArrayList<Integer>> fourSumTwo(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 4) {
            return res;
        }

        Arrays.sort(num);
        
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        
        for (int i = 0; i <= num.length - 4; i ++) {
            for (int j = i + 1; j <= num.length - 3; j ++) {
                for (int k = j + 1, h = num.length - 1; k < h;) {
                    int sum = num[i] + num[j] + num[k] + num[h];
                    
                    if (sum < target) {
                        k ++;
                        continue;
                    }
                    
                    if (sum > target) {
                        h --;
                        continue;
                    }
                    
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[j]);
                    tmp.add(num[k]);
                    tmp.add(num[h]);
                    
                    if (! hashSet.contains(tmp)) {
                        hashSet.add(tmp);
                        res.add(tmp);
                    }
                    k ++;
                    h --;
                }
            }
        }
        
        return res;
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

            ArrayList<ArrayList<Integer>> res = fourSumTwo(num, target);

            System.out.println(res);
        }

        cin.close();
    }

}
