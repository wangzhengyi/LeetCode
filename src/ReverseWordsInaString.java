import java.util.Scanner;


public class ReverseWordsInaString {
    public static String reverseWords(String s) {
        StringBuilder sBuilder = new StringBuilder(s.trim()).reverse();
        StringBuilder sTmp = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sBuilder.length();) {
            if (sBuilder.charAt(i) != ' ') {
                sTmp.append(sBuilder.charAt(i));
                i += 1;
            } else {
                result.append(sTmp.reverse().toString()).append(" ");
                sTmp.delete(0, sTmp.length());
                for (int j = i; sBuilder.charAt(j) == ' '; j ++) {
                    i += 1;
                }
            }
        }

        if (sTmp.length() > 0) {
            result.append(sTmp.reverse().toString());
        }
        
        return result.toString();
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String str = cin.nextLine();

            String res = reverseWords(str);

            System.out.println(res);
        }

        cin.close();
    }
}
