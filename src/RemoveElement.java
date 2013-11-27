import java.util.*;

public class RemoveElement {
    public static int removeElement(int[] A, int elem) {
        int i, k = 0;
        
        for (i = 0; i < A.length; i ++) {
            if (A[i] != elem) {
                A[k ++] = A[i];
            }
        }
        
        return k;
    }

    public static void main(String args[]) {
        int elem, len, i, n, A[];
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();
            A = new int[n];

            for (i = 0; i < n; i++) {
                A[i] = cin.nextInt();
            }

            elem = cin.nextInt();

            len = removeElement(A, elem);

            System.out.println(len);
        }

        cin.close();
    }
}
