import java.util.Scanner;


public class SearchInsertPosition {
    public static int searchInsert(int[] A, int target) {
        if (A.length == 0)  return 0;
        
        int bt, ed, mid;
        
        bt = 0; ed = A.length - 1;
        
        while (bt <= ed) {
            mid = bt + (ed - bt) / 2;
            
            if (A[mid] > target) {
                ed = mid - 1;
            } else if (A[mid] < target) {
                bt = mid + 1;
            } else {
                return mid;
            }
        }
        
        return bt;
    }
    
    public static void main(String args[]) {
        int target, n, loc, A[];
        
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            n = cin.nextInt();
            A = new int[n];
            
            for(int i = 0; i < n; i ++) {
                A[i] = cin.nextInt();
            }
            
            target = cin.nextInt();
            
            loc = searchInsert(A, target);
            
            System.out.println(loc);
        }
        
        cin.close();
    }
}
