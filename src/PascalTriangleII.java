import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class PascalTriangleII {
    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i ++) {
            list.add(0);
        }
        
        list.set(0, 1);
        
        for (int i = 1; i <= rowIndex; i ++) {
            list.set(i, 1);
            for (int j = i - 1; j > 0; j --) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        int n;
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            n = cin.nextInt();
            ArrayList<Integer> list = getRow(n);
            Iterator<Integer> iter = list.iterator();
            
            while (iter.hasNext()) {
                System.out.printf("%d ", iter.next());
            }
            System.out.println();
        }
        
        cin.close();
    }
}
