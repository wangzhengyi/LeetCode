import java.util.Scanner;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        boolean flag = true;

        int bt = 0, ed = s.length() - 1;

        while (bt < ed) {
            while (bt < ed && !isAlphanumeric(s.charAt(bt))) {
                bt++;
            }
            while (bt < ed && !isAlphanumeric(s.charAt(ed))) {
                ed--;
            }

            if (Character.toUpperCase(s.charAt(bt)) != Character.toUpperCase(s.charAt(ed))) {
                flag = false;
                break;
            } else {
                bt ++;
                ed --;
            }
        }

        return flag;
    }

    public static boolean isAlphanumeric(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        } else {
            ch = Character.toUpperCase(ch);
            if (ch >= 'A' && ch <= 'Z') {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String str = cin.nextLine();

            if (isPalindrome(str)) {
                System.out.println(str + " is a palindrome");
            } else {
                System.out.println(str + " is not a palindrome");
            }
        }

        cin.close();
    }

}
