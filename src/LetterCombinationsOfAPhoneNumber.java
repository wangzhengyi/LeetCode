import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class LetterCombinationsOfAPhoneNumber {
    public static HashMap<Character, String> map;

    public static ArrayList<String> letterCombinations(String digits) {
        // 1. create reference hash map
        map = new HashMap<Character, String>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        // 2. depth first search the digits
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder tmp = new StringBuilder();
        dfsDigits(0, digits.length(), digits, tmp, res);

        return res;
    }

    public static void dfsDigits(int index, int len, String digits, StringBuilder tmp,
            ArrayList<String> res) {
        if (index == len) {
            String str = tmp.toString();
            res.add(str);
        } else {
            String phone = map.get(digits.charAt(index));

            for (int i = 0; i < phone.length(); i++) {
                tmp.append(phone.charAt(i));
                dfsDigits(index + 1, len, digits, tmp, res);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }
    
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String digits = cin.nextLine();

            ArrayList<String> res = letterCombinations(digits);

            System.out.println(res);
        }

        cin.close();
    }
}
