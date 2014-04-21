
public class ImplementstrStr {
    public String strStr(String haystack, String needle) {
        String res = null;
        int i, j, k;
        
        if (haystack == null || needle == null || needle.length() == 0) {
            return haystack;
        }
        
        if (needle.length() > haystack.length()) {
            return null;
        }
        
        for (i = 0; i <= haystack.length() - needle.length(); i ++) {
            for (j = 0, k = i; j < needle.length(); j ++, k ++) {
                if (haystack.charAt(k) != needle.charAt(j)) {
                    break;
                }
            }
            
            if (j == needle.length()) {
                res = haystack.substring(i);
                break;
            }
        }
        
        return res;
    }
}
