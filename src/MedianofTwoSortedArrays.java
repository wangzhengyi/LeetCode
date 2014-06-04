import java.util.ArrayList;


public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        ArrayList<Integer> arrays = new ArrayList<Integer>();
        
        int i, j;
        
        for (i = j = 0; i < A.length && j < B.length;) {
            if (A[i] <= B[j]) {
                arrays.add(A[i ++]);
            } else {
                arrays.add(B[j ++]);
            }
        }
        
        while (i < A.length) {
            arrays.add(A[i ++]);
        }
        
        while (j < B.length) {
            arrays.add(B[j ++]);
        }
        
        double res = 0;
        if (arrays.size() % 2 == 1) {
            res = arrays.get(arrays.size() / 2);
        } else {
            res = (arrays.get(arrays.size() / 2) + arrays.get(arrays.size() / 2 - 1)) / 2.0;
        }
        
        return res;
    }
}
