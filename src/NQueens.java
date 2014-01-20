import java.util.ArrayList;
import java.util.Scanner;


public class NQueens {
    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        dfsNQueens(-1, n, list, res);
        
        return res;
    }

    public static void dfsNQueens(int x, int n, ArrayList<Integer> list, ArrayList<String[]> res) {
        if (x == n - 1) {
            String[] str = new String[n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                StringBuilder tmpstr = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    tmpstr.append('.');
                }
                int changeloc = list.get(i);

                tmpstr.setCharAt(changeloc, 'Q');

                String inStr = tmpstr.toString();
                str[count++] = inStr;
            }

            res.add(str);
        } else {
            for (int i = 0; i < n; i ++) {
                boolean flag = true;
                int tmpx = x + 1;
                int tmpy = i;
                
                for (int j = 0; j < list.size(); j ++) {
                    if (list.get(j) == tmpy || Math.abs(tmpy - list.get(j)) == Math.abs(tmpx - j)) {
                        flag = false;
                        break;
                    }
                }
                
                if (flag) {
                    list.add(tmpy);
                    dfsNQueens(tmpx, n, list, res);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            int n = cin.nextInt();
            
            ArrayList<String[]> res = solveNQueens(n);
            
            for (int i = 0; i < res.size(); i ++) {
                for (int j = 0; j < res.get(i).length; j ++) {
                    System.out.println(res.get(i)[j]);
                }
            }
        }
        
        cin.close();
    }
}
