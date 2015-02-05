
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] num) {
    	if (num == null || num.length == 0) {
    		return 0;
    	}
    	
    	int left = 0, right = num.length - 1, min = num[left], mid = 0;
    	
    	while (left < right) {
    		mid = (left + right) / 2;
    		
    		if (mid == left || mid == right) {
    			break;
    		}
    		
    		while (num[left] == num[mid] && left < right) {
    			left ++;
    		}
    		
    		while (num[right] == num[mid] && left < right) {
    			right --;
    		}
    		
    		if (num[left] < num[mid]) {
    			min = Math.min(min, num[left]);
    			left = mid + 1;
    		} else if (num[mid] < num[right]) {
    			min = Math.min(min, num[mid]);
    			right = mid - 1;
    		}
    	}
    	
    	min = Math.min(num[left], min);
    	min = Math.min(num[right], min);

    	return min;
    }
}
