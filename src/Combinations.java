import java.util.*;


public class Combinations {
    public static void main(String args[]) {
        int n, k;
        Scanner cin = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> rs = null;
        
        while (cin.hasNext()) {
            n = cin.nextInt();
            k = cin.nextInt();
            
            rs = combine(n, k);
            
            for (int i = 0; i < rs.size(); i ++) {
                for (int j = 0; j < rs.get(i).size(); j ++) {
                    System.out.printf("%d ", rs.get(i).get(j));
                }
                System.out.println();
            }
        }
        
        cin.close();
    }
    
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        dfs(1, k, n, list, rs);
        
        return rs;
    }
    
    public static void dfs(int pos, int k, int n, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> rs) {
        if (list.size() == k) {
            rs.add(new ArrayList<Integer>(list));
        }
        
        for (int i = pos; i <= n; i ++) {
            list.add(i);
            dfs(i + 1, k, n, list, rs);
            list.remove(list.size() - 1);
        }
    }
}
