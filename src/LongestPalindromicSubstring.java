import java.util.Scanner;


public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        String res = null;
        
        int start, len;
        start = 0;
        len = 1;
        
        for (int i = 0; i < s.length(); i ++) {
            int bt, ed, tmpLen;
            
            // first situation
            bt = i - 1;
            ed = i + 1;
            tmpLen = 1;
            while (bt >=0 && ed < s.length() && s.charAt(bt) == s.charAt(ed)) {
                bt --;
                ed ++;
                tmpLen += 2;
            }
            
            if (tmpLen > len) {
                start = i;
                len = tmpLen;
            }
            
            // second situation
            bt = i;
            ed = i + 1;
            tmpLen = 0;
            while (bt >= 0 && ed < s.length() && s.charAt(bt) == s.charAt(ed)) {
                bt --;
                ed ++;
                tmpLen += 2;
            }
            
            if (tmpLen > len) {
                start = i;
                len = tmpLen;
            }
        }
        
        if (len % 2 == 0) {
            res = s.substring(start - (len / 2) + 1,  start + (len / 2) + 1);
        } else {
            res = s.substring(start - (len / 2), start + (len / 2) + 1);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            String str = cin.nextLine();
            
            String res = longestPalindrome(str);
            
            System.out.println(res);
        }
        
        cin.close();
    }
}
