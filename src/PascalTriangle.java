import java.util.*;

public class PascalTriangle {
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows < 1) {
            return result;
        }
        ArrayList<Integer> start = new ArrayList<Integer>();
        start.add(1);
        result.add(start);
        
        for (int i = 1; i < numRows; i ++) {
            ArrayList<Integer> pre = result.get(i - 1);
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            
            for (int j = 1; j < i; j ++) {
                int tmp = pre.get(j - 1) + pre.get(j);
                cur.add(tmp);
            }
            
            cur.add(1);
            
            result.add(cur);
        }
        
        return result;
    }
    
    
    public static void main(String args[]) {
        int n;
        ArrayList<ArrayList<Integer>> list;
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            n = cin.nextInt();
            list = generate(n);
            
            for (int i = 0; i < list.size(); i ++) {
                for (int j = 0; j < list.get(i).size(); j ++) {
                    System.out.printf("%d ", list.get(i).get(j));
                }
                System.out.println();
            }
        }
        
        cin.close();
    }
}
