import java.util.Scanner;

public class SearchForRange {
    public static int[] searchRange(int[] A, int target) {
        int res[] = new int[2], bt = 0, ed = A.length - 1, mid = 0;

        while (bt <= ed) {
            mid = bt + ((ed - bt) >> 1);
            if (A[mid] == target) {
                break;
            } else if (A[mid] > target) {
                ed = mid - 1;
            } else {
                bt = mid + 1;
            }
        }

        if (bt > ed) { // not found
            res[0] = res[1] = -1;
        } else { // found
            int is, ie;

            is = mid;
            while (is - 1 >= 0 && A[is - 1] == target) {
                is -= 1;
            }

            ie = mid;
            while (ie + 1 < A.length && A[ie + 1] == target) {
                ie += 1;
            }

            res[0] = is;
            res[1] = ie;
        }

        return res;
    }

    public static int[] searchRangeII(int[] A, int target) {
        int res[] = new int[2], bt, ed, mid;

        res[0] = res[1] = -1;

        bt = mid = 0;
        ed = A.length - 1;
        while (bt < ed) {
            mid = bt + ((ed - bt) >> 1);
            if (A[mid] < target) {
                bt = mid + 1;
            } else {
                ed = mid;
            }
        }

        if (A[bt] != target) {
            return res;
        } else {
            res[0] = bt;
        }

        bt = mid = 0;
        ed = A.length;
        while (bt < ed) {
            mid = bt + ((ed - bt) >> 1);
            if (A[mid] > target) {
                ed = mid;
            } else {
                bt = mid + 1;
            }
        }

        res[1] = ed - 1;

        return res;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int[] A = new int[cin.nextInt()];
            int target = cin.nextInt();

            for (int i = 0; i < A.length; i++) {
                A[i] = cin.nextInt();
            }

            int[] res = searchRangeII(A, target);

            for (int i = 0; i < res.length; i++) {
                System.out.printf("%d ", res[i]);
            }
            System.out.println();
        }

        cin.close();
    }
}
