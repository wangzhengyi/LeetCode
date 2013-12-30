import java.util.LinkedList;
import java.util.Scanner;


public class VaildParentheses {

    public static boolean checkMatching(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        } else if (left == '[' && right == ']') {
            return true;
        } else if (left == '{' && right == '}') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isVaild(String s) {
        boolean flag = true;
        LinkedList<Character> stack = new LinkedList<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.addFirst(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                } else {
                    char ch = stack.removeFirst();
                    if (!checkMatching(ch, s.charAt(i))) {
                        flag = false;
                        break;
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            flag = false;
        }

        return flag;
    }

    public static void main(String[] args) {
        String s;
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            s = cin.nextLine();

            boolean flag = isVaild(s);

            if (flag) {
                System.out.println("valid");
            } else {
                System.out.println("not valid");
            }
        }

        cin.close();
    }
}
