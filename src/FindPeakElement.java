public class FindPeakElement {
    public static int findPeakElement(int[] num) {
        if (num == null || num.length == 1) {
        	return 0;
        }
        
        int bt, ed, mid;
        
        for (bt = 0, ed = num.length - 1; bt < ed - 1;) {
        	mid = (ed - bt) / 2 + bt;
        	
        	if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
        		return mid;
        	}
        	
        	if (num[mid] < num[mid - 1]) {
        		ed = mid - 1;
        	} else {
        		bt = mid + 1;
        	}
        	
        }
        
        return num[bt] >= num[ed] ? bt : ed;
    }
}
