import java.util.Scanner;


public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i, j, tmp, bit, carry = 0;

        for (i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
            tmp = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            bit = tmp % 2;
            carry = tmp / 2;
            res.append(bit);
        }

        while (i >= 0) {
            tmp = a.charAt(i--) - '0' + carry;
            bit = tmp % 2;
            carry = tmp / 2;
            res.append(bit);
        }

        while (j >= 0) {
            tmp = b.charAt(j--) - '0' + carry;
            bit = tmp % 2;
            carry = tmp / 2;
            res.append(bit);
        }

        while (carry > 0) {
            bit = carry % 2;
            carry /= 2;
            res.append(bit);
        }

        res.reverse();

        return res.toString();
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String a = cin.nextLine();
            String b = cin.nextLine();

            String res = addBinary(a, b);
            System.out.println(res);
        }

        cin.close();
    }
}
