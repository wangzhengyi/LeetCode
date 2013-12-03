import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class SingleNumberII {
    /**
     * 使用HashMap解决singleNumberII问题
     * 
     * @param A
     * @return
     */
    public static int singleNumberI(int[] A) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int i, target = A[0];

        for (i = 0; i < A.length; i++) {
            if (hm.containsKey(A[i])) {
                hm.put(A[i], hm.get(A[i]) + 1);
            } else {
                hm.put(A[i], 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> itor = hm.entrySet().iterator();

        while (itor.hasNext()) {
            Map.Entry<Integer, Integer> entry = itor.next();
            if (entry.getValue() != 3) {
                target = entry.getKey();
                break;
            }
        }

        return target;
    }

    /**
     * 利用位运算和取余实现
     * 
     * @param A
     * @return
     */
    public static int singleNumberII(int[] A) {
        int i, j, bit, result = 0;

        for (i = 0; i < 32; i++) {
            for (j = bit = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) == 1) {
                    bit++;
                }
            }

            bit = bit % 3;

            result |= bit << i;
        }

        return result;
    }

    public static void main(String[] args) {
        int i, n, single, A[];
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();
            A = new int[n];

            for (i = 0; i < n; i++) {
                A[i] = cin.nextInt();
            }

            single = singleNumberI(A);

            System.out.println(single);

            single = singleNumberII(A);
            System.out.println(single);
        }

        cin.close();
    }
}
