import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class LargestNumber {
    public static String largestNumber(int[] num) {
        StringBuilder res = new StringBuilder();
        
        String[] numArrays = new String[num.length];
        int zeroNum = 0;
        for (int i = 0; i < num.length; i ++) {
        	if (num[i] == 0) {
        		zeroNum ++;
        	}
        	numArrays[i] = Integer.toString(num[i]);
        }
        
        if (zeroNum == num.length) {
        	return "0";
        }
             
        Arrays.sort(numArrays, new NumComparator());
        
        for (String s : numArrays) {
        	res.append(s);
        }      
        return res.toString();
    }
    
    
    private static class NumComparator implements Comparator<String> {

		@Override
		public int compare(String str1, String str2) {
			String cmp1 = str1 + str2;
			String cmp2 = str2 + str1;
			
			return cmp1.compareTo(cmp2) * -1;
		}
    	
    }
    
    public static void main(String[] args) {
    	Scanner cin = new Scanner(System.in);
    	
    	while (cin.hasNext()) {
    		int n = cin.nextInt();
    		int[] num = new int[n];
    		
    		for (int i = 0; i < n; i ++) {
    			num[i] = cin.nextInt();
    		}
    		
    		String largeNum = largestNumber(num);
    		System.out.println(largeNum);
    	}
    	
    	cin.close();
    }
}
