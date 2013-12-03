import java.util.Scanner;


public class SearchInRotatedArray {
    public static int search(int[] A, int target) {
        int bt, ed, mid, loc = -1;
        
        bt = 0; ed = A.length - 1;
        
        while (bt <= ed) {
            mid = bt + (ed - bt) / 2;
            
            if (A[mid] == target) {
                loc = mid;
                break;
            }
            
            if (A[mid] >= A[bt]) {
                if (target >= A[bt] && target < A[mid]) {
                    ed = mid - 1;
                } else {
                    bt = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[ed]) {
                    bt = mid + 1;
                } else {
                    ed = mid - 1;
                }
            }
        }
        
        return loc;
    }
    
    public static void main(String args[]) {
        int i, n, target, loc, A[];
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            n = cin.nextInt();
            target = cin.nextInt();
            
            A = new int[n];
            
            for (i = 0; i < n; i ++) {
                A[i] = cin.nextInt();
            }
                
            loc = search(A, target);
            System.out.println(loc);
        }
        
        cin.close();
    }
}
