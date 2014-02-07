import java.util.Scanner;


public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        // initialize number array
        int[] seq = new int[n];

        for (int i = 1; i <= n; i++) {
            seq[i - 1] = i;
        }

        // loop from 1 to k
        if (k == 1) {
            return arrayToString(seq);
        }
        for (int i = 2; i <= k; i++) {
            // find the partition number
            int partLoc = seq.length - 1;
            for (; partLoc - 1 >= 0; partLoc--) {
                if (seq[partLoc - 1] < seq[partLoc]) {
                    break;
                }
            }
            partLoc -= 1;

            // find the change number
            int chLoc = seq.length - 1;
            for (; chLoc > partLoc; chLoc--) {
                if (seq[chLoc] > seq[partLoc]) {
                    break;
                }
            }

            // swap the two numbers
            if (chLoc != partLoc) {
                seq[partLoc] = seq[partLoc] ^ seq[chLoc];
                seq[chLoc] = seq[partLoc] ^ seq[chLoc];
                seq[partLoc] = seq[partLoc] ^ seq[chLoc];
            }

            // reverse all the digit on the right of the partition location
            for (int j = partLoc + 1, h = seq.length - 1; j < h; j++, h--) {
                seq[j] = seq[j] ^ seq[h];
                seq[h] = seq[j] ^ seq[h];
                seq[j] = seq[j] ^ seq[h];
            }
        }

        return arrayToString(seq);
    }

    public static String arrayToString(int[] array) {
        StringBuilder str = new StringBuilder();

        for (int num : array) {
            str.append(num);
        }

        return str.toString();
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int k = cin.nextInt();

            String res = getPermutation(n, k);

            System.out.println(res);
        }

        cin.close();
    }
}
