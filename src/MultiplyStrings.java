import java.util.Scanner;


public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        StringBuilder numOne = new StringBuilder(num1).reverse();
        StringBuilder numTwo = new StringBuilder(num2).reverse();

        int[] dp = new int[numOne.length() + numTwo.length()];

        for (int i = 0; i < numOne.length(); i++) {
            int first = numOne.charAt(i) - '0';
            for (int j = 0; j < numTwo.length(); j++) {
                int second = numTwo.charAt(j) - '0';
                dp[i + j] += first * second;
            }
        }

        StringBuilder multiply = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < dp.length; i++) {
            int tmp = (dp[i] + carry) % 10;
            carry = (dp[i] + carry) / 10;
            multiply.append(tmp);
        }

        while (carry > 0) {
            int tmp = carry % 10;
            carry /= 10;
            multiply.append(tmp);
        }

        for (int i = multiply.length() - 1; i >= 1; i --) {
            if (multiply.charAt(i) == '0') {
                multiply.deleteCharAt(i);
            } else {
                break;
            }
        }
        
        return multiply.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String num1 = cin.nextLine();
            String num2 = cin.nextLine();

            String res = multiply(num1, num2);

            System.out.println(res);
        }

        cin.close();
    }
}
