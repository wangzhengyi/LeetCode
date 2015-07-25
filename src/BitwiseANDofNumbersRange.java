
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
    	int moveF = 1;
    	
    	while (m != n) {
    		m >>= 1;
    		n >>= 1;
    		moveF <<= 1;
    	}
        
        return m << moveF;
    }
    
    public static void main(String[] args) {
    	int m = 5, n = 7;
    	
    	BitwiseANDofNumbersRange bitNR = new BitwiseANDofNumbersRange();
    	int res = bitNR.rangeBitwiseAnd(m, n);
    	System.out.println(res);
    }
}
 