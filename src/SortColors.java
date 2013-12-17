import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class SortColors {
    public static void main(String args[]) {
        int i, n, A[];
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            n = cin.nextInt();
            A = new int[n];
            
            for (i = 0; i < n; i ++) {
                A[i] = cin.nextInt();
            }
            
            sortColors(A);
            
            for (i = 0; i < A.length; i ++) {
                System.out.printf("%d ", A[i]);
            }
            System.out.println();
        }
        
        cin.close();
    }
    
    public static void sortColors(int[] A) {
        int key, value, len = 0;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < A.length; i ++) {
            if (map.get(A[i]) == null) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
        }
        
        Iterator<Integer> iter = map.keySet().iterator();
        
        while (iter.hasNext()) {
            key = iter.next();
            value = map.get(key);
            while (value > 0) {
                A[len ++] = key;
                value --;
            }
        }
    }
}   
