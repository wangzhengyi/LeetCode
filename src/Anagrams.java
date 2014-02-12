import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Anagrams {
    public static ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();

        if (strs == null || strs.length == 0) {
            return res;
        }

        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length; i++) {
            String tmp = sortSingleString(strs[i]);
            if (!hashmap.containsKey(tmp)) {
                hashmap.put(tmp, i);
            } else {
                int loc = hashmap.get(tmp);
                if (loc != -1) {
                    res.add(strs[loc]);
                }
                res.add(strs[i]);
                hashmap.put(tmp, -1);
            }
        }

        return res;
    }

    public static String sortSingleString(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        String res = new String(array);

        return res;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = Integer.parseInt(cin.nextLine());
            String[] strs = new String[n];

            for (int i = 0; i < n; i++) {
                strs[i] = cin.nextLine();
            }

            ArrayList<String> res = anagrams(strs);

            System.out.println(res);
        }

        cin.close();
    }
}
