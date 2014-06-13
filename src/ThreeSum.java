import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (num.length < 3) {
            return res;
        }

        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            // avoid duplicate
            if (i == 0 || num[i] > num[i - 1]) {
                int start = i + 1;
                int end = num.length - 1;

                while (start < end) {
                    int stand = num[i] + num[start] + num[end];
                    if (stand == 0) {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[start]);
                        tmp.add(num[end]);
                        res.add(tmp);
                        start++;
                        end--;
                        //avoid duplicate
                        while (start < end && num[start] == num[start - 1]) {
                            start ++;
                        }
                        while (start < end && num[end] == num[end + 1]) {
                            end --;
                        }
                    } else if (stand > 0) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = Integer.valueOf(cin.nextLine());
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = cin.nextInt();
            }

            List<List<Integer>> res = threeSum(num);

            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i));
            }
        }

        cin.close();
    }
}
