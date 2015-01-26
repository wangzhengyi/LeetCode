import java.util.Arrays;


public class MajorityElement {
    public int majorityElement(int[] num) {
        int element = -1;
        
        if (num.length == 1) {
        	element = num[0];
        } else {
        	Arrays.sort(num);
        	int mid = (0 + num.length) / 2;
        	element = num[mid];
        }
        
        return element;
    }
}
