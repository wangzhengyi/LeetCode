import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class GenerateParentheses {
    public static void main(String[] args) {
        int n;
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();

            ArrayList<String> list = generateParenthesis(n);
            Iterator<String> iter = list.iterator();

            while (iter.hasNext()) {
                String tmp = iter.next();
                System.out.println(tmp);
            }
        }

        cin.close();
    }

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        StringBuilder str = new StringBuilder();

        if (n == 0) {
            return list;
        }

        recursive(0, 0, n, str, list);

        return list;
    }

    public static void recursive(int left, int right, int n, StringBuilder str,
            ArrayList<String> list) {
        if (left < right) {
            return;
        }

        if (left == n && right == n) {
            String tmp = str.toString();
            list.add(tmp);
            return;
        }

        if (left < n) {
            StringBuilder newstr = new StringBuilder(str.toString());
            newstr.append('(');
            recursive(left + 1, right, n, newstr, list);
        }

        if (right < n) {
            StringBuilder newstr = new StringBuilder(str.toString());
            newstr.append(')');
            recursive(left, right + 1, n, newstr, list);
        }
    }

}
