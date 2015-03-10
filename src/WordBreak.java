import java.util.Set;


public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
    	if (s == null || s.length() == 0) {
    		return true;
    	}
    	
    	// initial boolean array
    	boolean[] locs = new boolean[s.length() + 1];
    	for (int i = 0; i < locs.length; i ++) {
    		locs[i] = false;
    	}
    	locs[0] = true;
    	
    	// dynamic programming
    	for (int i = 1; i < locs.length; i ++) {
    		locs[i] = false;
    		
    		for (int j = 0; j < i; j ++) {
    			if (locs[j] && dict.contains(s.substring(j, i))) {
    				locs[i] = true;
    				break;
    			}
    		}
    	}
    	
    	return locs[locs.length - 1];
    }
}
