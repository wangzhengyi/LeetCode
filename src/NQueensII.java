import java.util.ArrayList;
import java.util.Scanner;


public class NQueensII {
    public static int sum;

    public static int totalNQueens(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        sum = 0;

        dfsNQueens(0, n, list);

        int res = sum;

        return res;
    }

    public static void dfsNQueens(int x, int n, ArrayList<Integer> list) {
        if (x == n) {
            sum += 1;
        } else {
            for (int i = 1; i <= n; i++) {
                int tmpx = x + 1;
                int tmpy = i;
                boolean flag = true;

                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == tmpy
                            || (Math.abs(tmpy - list.get(j)) == Math.abs(tmpx - j - 1))) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    list.add(tmpy);
                    dfsNQueens(tmpx, n, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();

            int res = totalNQueens(n);

            System.out.println(res);
        }

        cin.close();
    }
}
