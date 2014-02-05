import java.util.HashSet;


public class FirstMissingPositive {
    public static int firstMissingPositive(int[] A) {
        int miss = A.length + 1;

        HashSet<Integer> hashset = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            hashset.add(A[i]);
        }

        for (int i = 1; i <= A.length; i++) {
            if (!hashset.contains(i)) {
                miss = i;
                break;
            }
        }

        return miss;
    }

    public static int firstMissingPostitiveInConstantPlace(int[] A) {
        int tmp, miss = A.length + 1;

        for (int i = 0; i < A.length;) {
            if (A[i] != i + 1 && A[i] >= 1 && A[i] <= A.length && A[i] != A[A[i] - 1]) {
                tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            } else {
                i ++;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                miss = i + 1;
                break;
            }
        }

        return miss;
    }
}
