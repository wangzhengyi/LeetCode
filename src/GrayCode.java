import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class GrayCode {
    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);

        int i, j, size, high;

        for (i = 0; i < n; i++) {
            high = 1 << i;
            size = list.size();

            for (j = size - 1; j >= 0; j--) {
                list.add(list.get(j) + high);;
            }
        }

        return list;
    }


    public static void main(String[] args) {
        int n;
        ArrayList<Integer> list;
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();
            list = grayCode(n);

            Iterator<Integer> iter = list.iterator();

            while (iter.hasNext()) {
                int data = iter.next();
                System.out.printf("%d ", data);
            }

            System.out.println();
        }

        cin.close();
    }
}
