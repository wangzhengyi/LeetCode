import java.util.Scanner;


public class LongestCommonPrefix {
    public static void main(String[] args) {
        int i, n;
        String[] strs;
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = Integer.parseInt(cin.nextLine());
            strs = new String[n];
           
            for (i = 0; i < n; i++) {
                strs[i] = cin.nextLine();
            }

            String rs = longestCommonPrefix(strs);

            System.out.println(rs);
        }

        cin.close();
    }


    public static String longestCommonPrefix(String[] strs) {
        String shortest = "";
        if (strs == null || strs.length == 0) {
            return shortest;
        }

        shortest = strs[0];
        for (int i = 1; i < strs.length; i++) {
            StringBuilder sBuilder = new StringBuilder();

            int k = 0;
            while (k < shortest.length() && k < strs[i].length()) {
                if (shortest.charAt(k) == strs[i].charAt(k)) {
                    sBuilder.append(shortest.charAt(k));
                    k ++;
                } else {
                    break;
                }
            }

            shortest = sBuilder.toString();
        }

        return shortest;
    }
}
