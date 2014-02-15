import java.util.Scanner;


public class StringToInteger {
    public static int atoi(String str) {
        // replace previous whitespace characters
        str = str.trim();
        
        // special case
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        // false for negative, true for positive
        boolean flag = true;
        int index = 0;
        long max = Integer.MAX_VALUE;

        if (str.charAt(index) == '-') {
            max = 2147483648L;
            flag = false;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        }

        // convert string to integer
        int res = 0;
        int boundary = (int) (max / 10);
        int limit = (int) (max % 10);


        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }
            
            if (res > boundary || res == boundary && str.charAt(index) - '0' > limit) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                res = res * 10 + (str.charAt(index) - '0');
            }
        }

        return flag ? res : res * -1;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String str = cin.nextLine();

            int res = atoi(str);

            System.out.printf("%d\n", res);
        }

        cin.close();
    }
}
