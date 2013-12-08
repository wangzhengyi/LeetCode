import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class PlusOne {
    public static void main(String args[]) {
        int i, n, digits[];
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            n = cin.nextInt();
            digits = new int[n];
            
            for (i = 0; i < n; i ++) {
                digits[i] = cin.nextInt();
            }
            
            digits = plusOne(digits);
            
            System.out.println(Arrays.toString(digits));
        }
        
        cin.close();
    }
    
    public static int[] plusOne(int[] digits) {
        int i, j, c, data, result[];
        List<Integer> list = new ArrayList<Integer>();

        for (i = digits.length - 1, c = 1; i >= 0; i--) {
            data = digits[i] + c;
            list.add(data % 10);
            if (data < 10) {
                c = 0;
            } else {
                c = data / 10;
            }
        }

        while (c > 0) {
            list.add(c % 10);
            c /= 10;
        }
        
        result = new int[list.size()];
        
        for (i = list.size() - 1, j = 0; i >= 0; i --, j ++) {
            result[j] = list.get(i).intValue();
        }
        
        return result;
    } 
}
