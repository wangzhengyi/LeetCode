import java.util.Scanner;
import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sBuilder = new StringBuilder(s);


        for (int i = 0; i < s.length(); i++) {
            if (sBuilder.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    sBuilder.setCharAt(i, 'a');
                    sBuilder.setCharAt(stack.pop(), 'a');
                }
            }
        }

        int max = 0, len = 0;
        for (int i = 0; i < sBuilder.length(); i++) {
            if (sBuilder.charAt(i) == 'a') {
                len++;
                max = Math.max(max, len);
            } else {
                len = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String s = cin.nextLine();

            int len = longestValidParentheses(s);

            System.out.println(len);
        }

        cin.close();
    }
}
