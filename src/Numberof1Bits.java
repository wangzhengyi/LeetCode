
public class Numberof1Bits {
	// you need to treat n as an unsigned value
	public static int hammingWeight(int n) {
		int num = 0;
		while (n != 0) {
			num += n & 1;
			n >>>= 1;
		}
		return num;
	}

}
