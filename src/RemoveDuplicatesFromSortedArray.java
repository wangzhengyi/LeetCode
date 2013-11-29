import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int i, n, len, A[];
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();
            A = new int[n];

            for (i = 0; i < n; i++) {
                A[i] = cin.nextInt();
            }

            len = removeDuplicates(A);
            System.out.println(len);

            for (i = 0; i < len; i++) {
                System.out.printf("%d ", A[i]);
            }
            System.out.printf("\n");
        }

        cin.close();
    }

    /**
     * github修改email时，注意同步本地的email，方法git config --global user.email ""
     * 
     * @param A
     * @return
     */
    public static int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;

        int i, k = 0;

        for (i = 0; i < A.length - 1; i++) {
            if (A[i + 1] == A[i]) {
                A[k] = A[i + 1];
            } else {
                A[++k] = A[i + 1];
            }
        }

        return k + 1;
    }
}
