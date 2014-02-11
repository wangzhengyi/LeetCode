import java.util.HashMap;
import java.util.Scanner;


public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int bt, ed, max, len;

        for (bt = ed = max = len = 0; ed < s.length(); ed++) {
            len ++;
            if (!hashMap.containsKey(s.charAt(ed))) {
                hashMap.put(s.charAt(ed), ed);
            } else {
                int loc = hashMap.get(s.charAt(ed));
                for (int i = bt; i <= loc; i ++) {
                    len -= 1;
                    hashMap.remove(s.charAt(i));
                }
                hashMap.put(s.charAt(ed), ed);
                bt = loc + 1;
            }

            if (len > max) {
                max = len;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String s = cin.nextLine();

            int len = lengthOfLongestSubstring(s);

            System.out.println(len);
        }

        cin.close();
    }
}
