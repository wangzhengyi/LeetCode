import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Permutations {
    public static void main(String args[]) {
        int i, n, num[];
        ArrayList<ArrayList<Integer>> list;
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();
            num = new int[n];

            for (i = 0; i < n; i++) {
                num[i] = cin.nextInt();
            }

            list = permute(num);

            Iterator<ArrayList<Integer>> iter = list.iterator();

            while (iter.hasNext()) {
                ArrayList<Integer> child = iter.next();
                Iterator<Integer> citer = child.iterator();

                while (citer.hasNext()) {
                    System.out.printf("%d ", citer.next());
                }
                System.out.println();
            }
        }

        cin.close();
    }

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        if (num.length == 0) {
            return list;
        }

        permutationProcess(num, 0, num.length - 1, list);

        return list;
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

    public static void swapArray(int[] num, int a, int b) {
        if (a != b) {
            num[a] = num[a] ^ num[b];
            num[b] = num[a] ^ num[b];
            num[a] = num[a] ^ num[b];
        }
    }

    public static void permutationProcess(int[] num, int bt, int ed,
            ArrayList<ArrayList<Integer>> list) {
        if (bt == ed) {
            ArrayList<Integer> newlist = new ArrayList<Integer>(num.length);
            for (int val : num) {
                newlist.add(Integer.valueOf(val));
            }
            list.add(newlist);
        } else {
            for (int k = bt; k <= ed; k++) {
                if (shouldSwap(num, bt, k)) {
                    swapArray(num, bt, k);
                    permutationProcess(num, bt + 1, ed, list);
                    swapArray(num, bt, k);
                }
            }
        }
    }
}
