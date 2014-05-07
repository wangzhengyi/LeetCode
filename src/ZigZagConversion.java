
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows <= 0) {
            return "";
        }
        
        if (nRows == 1) {
            return s;
        }
        
        StringBuilder res = new StringBuilder();
        
        int size = 2 * nRows - 2;
        
        for (int i = 0; i < nRows; i ++) {
            for (int j = i; j < s.length(); j += size) {
                res.append(s.charAt(j));
                if (i != 0 && i != nRows - 1 && j + size - i * 2 < s.length()) {
                    res.append(s.charAt(j + size - i * 2));
                }
            }
        }
        
        return res.toString();
    }
}
