import java.util.*;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n, steps;
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            n = cin.nextInt();
            
            steps = climbStairs(n);
            
            System.out.println(steps);
        }
        
        cin.close();
    }
    
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int a, b, c, i;
        for (i = 3, a = 1, b = 2, c = 0; i <= n; i ++) {
            c = a + b;
            a = b;
            b = c;
        }
        
        return c;
    }
}
