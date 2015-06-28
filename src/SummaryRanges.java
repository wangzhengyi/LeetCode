import java.util.ArrayList;
import java.util.List;


public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        for (int i = 0, len = nums.length; i < len;) {
        	String ranges = String.valueOf(nums[i]);
        	int distance = 1;
        	while (i + distance < len && (nums[i + distance] - nums[i + distance - 1] == 1)) {
        		if (distance == 1) {
        			ranges += "->";
        		}
        		distance ++;
        	}
        	
        	if (distance > 1) {
        		ranges += String.valueOf(nums[i + distance - 1]);
        	}
        	res.add(ranges);
        	i += distance;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	int[] nums = new int[] {0,1,2,4,5,7};
    	SummaryRanges sr = new SummaryRanges();
    	List<String> list = sr.summaryRanges(nums);
    	
    	for(String str : list) {
    		System.out.println(str);
    	}    	
    }
}
