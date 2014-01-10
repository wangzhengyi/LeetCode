import java.util.Scanner;


public class LengthOfLastWord {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String s = cin.nextLine();

            int len = lengthOfLastWord(s);

            System.out.println(len);
        }

        cin.close();
    }

    public static int lengthOfLastWord(String s) {
        if (s.equals("")) {
            return 0;
        }

        int len, res;

        for (len = s.length() - 1; len >= 0 && s.charAt(len) == ' '; len--) ;

        for (res = 0; len >= 0 && s.charAt(len) != ' '; len --, res++) ;

        return res;
    }
}
