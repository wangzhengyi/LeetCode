

public class ReverseBits {
    public int reverseBits(int n) {
    	int res = 0;
    	
    	for (int i = 0; i < Integer.SIZE; i ++) {
    		int bit = n & 1;
    		
    		res = (res << 1) | bit;
    		
    		n >>= 1;
    	}
    	
    	return res;
    }
}
