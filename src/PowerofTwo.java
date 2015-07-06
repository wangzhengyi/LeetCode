
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
    	return n <= 0 ? false : (n & (n - 1)) == 0;
    }
    
    public static void main(String[] args) {
    	int n = 256;
    	
    	PowerofTwo pot = new PowerofTwo();
    	boolean  res = pot.isPowerOfTwo(n);
    	
    	System.out.println(res);
    }
}
