import java.util.TreeSet;


public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	TreeSet<Integer> mTreeSet = new TreeSet<Integer>();
    	
    	for (int i = 0; i < nums.length; i ++) {
    		Integer floor = mTreeSet.floor(nums[i] + t);
    		Integer ceil = mTreeSet.ceiling(nums[i] - t);
    		
    		if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
    			return true;
    		}
    		
    		mTreeSet.add(nums[i]);
    		if (i >= k) {
    			mTreeSet.remove(nums[i - k]);
    		}
    	}
    	
    	return false;
    }
}
