import java.util.ArrayList;
import java.util.Scanner;


public class PalindromePartitioning {
    public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> tmp = new ArrayList<String>();

        if (s == null || s.length() == 0) {
            return res;
        }

        depthFirstSearch(0, s, tmp, res);

        return res;
    }

    public static void depthFirstSearch(int start, String s, ArrayList<String> tmp,
            ArrayList<ArrayList<String>> res) {
        if (start >= s.length()) {
            res.add(new ArrayList<String>(tmp));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i + 1)) {
                    tmp.add(s.substring(start, i + 1));
                    depthFirstSearch(i + 1, s, tmp, res);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    public static boolean isPalindrome(String s, int bt, int ed) {
        for (; bt < ed; bt++, ed--) {
            if (s.charAt(bt) != s.charAt(ed)) {
                return false;
            }
        }

        return true;
    }
    
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            String s = cin.nextLine();
            
            System.out.println(s.substring(1, 3));
        }
        
        cin.close();
    }
}
