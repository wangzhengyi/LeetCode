import java.util.Scanner;


public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] A = new int[n];

            for (int i = 0; i < n; i++) {
                A[i] = cin.nextInt();
            }

            int volume = trap(A);

            System.out.println(volume);
        }

        cin.close();
    }

    public static int trap(int[] A) {
        // special case
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int i, max, volume, left[] = new int[A.length], right[] = new int[A.length];

        // from left to right
        for (left[0] = A[0], i = 1, max = A[0]; i < A.length; i++) {
            if (A[i] < max) {
                left[i] = max;
            } else {
                left[i] = A[i];
                max = A[i];
            }
        }

        // from right to right
        for (right[A.length - 1] = A[A.length - 1], i = A.length - 2, max = A[A.length - 1]; i >= 0; i--) {
            if (A[i] < max) {
                right[i] = max;
            } else {
                right[i] = A[i];
                max = A[i];
            }
        }

        // trapped water
        for (volume = 0, i = 0; i <= A.length - 1; i++) {
            int tmp = Math.min(left[i], right[i]) - A[i];
            if (tmp > 0) {
                volume += tmp;
            }
        }

        return volume;
    }

}
