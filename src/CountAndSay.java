import java.util.Scanner;


public class CountAndSay {
    public static String countAndSay(int n) {
        if (n <= 1) {
            return "1";
        }

        StringBuilder res = new StringBuilder("1");
        while (n-- > 1) {
            int i, j;
            StringBuilder tmp = new StringBuilder();
            for (i = 0; i < res.length();) {
                int count = 1;
                for (j = i + 1; j < res.length() && res.charAt(j) == res.charAt(i); j++) {
                    count++;
                }

                tmp.append(count).append(res.charAt(i));
                i = j;
            }

            res.delete(0, res.length() - 1);
            res = tmp;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();

            String res = countAndSay(n);

            System.out.println(res);
        }

        cin.close();
    }
}
