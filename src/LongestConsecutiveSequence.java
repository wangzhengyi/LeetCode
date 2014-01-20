import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class LongestConsecutiveSequence {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int len = cin.nextInt();
            int num[] = new int[len];

            for (int i = 0; i < len; i++) {
                num[i] = cin.nextInt();
            }

            // int res = longestConsecutiveBySort(num);
            int res = longetConsecutive(num);

            System.out.println(res);
        }

        cin.close();
    }

    public static int longestConsecutiveBySort(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        Arrays.sort(num);

        int len, tmp, i;

        for (len = tmp = i = 0; i + 1 < num.length; i++) {
            if (num[i + 1] - num[i] == 1) {
                tmp++;
            } else if (num[i + 1] == num[i]) {
                continue;
            } else {
                if (tmp > len) {
                    len = tmp;
                }
                tmp = 0;
            }
        }

        if (tmp > len) {
            len = tmp;
        }

        return len + 1;
    }

    public static int longetConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }

        int res = 0;

        for (int i = 0; i < num.length; i++) {
            if (set.contains(num[i])) {
                set.remove(num[i]);

                int tmp = 1;
                int next = num[i] + 1;
                while (set.contains(next)) {
                    set.remove(next);
                    next++;
                    tmp++;
                }

                next = num[i] - 1;
                while (set.contains(next)) {
                    set.remove(next);
                    next--;
                    tmp++;
                }

                res = Math.max(tmp, res);
            }
        }

        return res;
    }
}
