import java.util.Scanner;


public class PalindromeNumber {
    public static void main(String[] args) {
        int x;
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            x = cin.nextInt();

            if (isPalindromeII(x)) {
                System.out.println("ok");
            } else {
                System.out.println("no");
            }
            
            if (isPalindrome(x)) {
                System.out.println("ok");
            } else {
                System.out.println("no");
            }
        }

        cin.close();
    }

    public static boolean isPalindromeII(int x) {
        if (x < 0) {
            return false;
        }

        String str = Integer.toString(x);
        boolean flag = true;

        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                flag = false;
                break;
            }
        }

        return flag;
    }
    
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int hp, sp, len, tmp;
        
        // determine the length of x
        hp = 1; len = 0; sp = 1; tmp = x;
        while (x > 0) {
            len ++;
            x /= 10;
            if (x > 0) {
                hp *= 10;
            }
        }
        
        // check isPalidrome
        boolean flag = true;
        for (int i = 0; i < len / 2; i ++, hp /= 10, sp *= 10) {
            // fetch high number and low number
            int high = (tmp / hp) % 10;
            int low = (tmp / sp) % 10;
            if (high != low) {
                flag = false;
                break;
            }
        }
        
        return flag;
    }
}
