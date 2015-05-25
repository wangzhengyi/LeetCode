import java.util.Scanner;


public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        
        for (int i = 0; i < k; i ++) {
        	heap[i] = nums[i];
        }
        
        // 构建k个元素的最小堆
        for (int i = k / 2 - 1; i >= 0; i --) {
        	modifyMinHeap(heap, k, i);
        }
        
        // 刷选最大的k个元素
        for (int i = k; i < nums.length; i ++) {
        	if (heap[0] < nums[i]) {
        		heap[0] = nums[i];
        		modifyMinHeap(heap, k, 0);
        	}
        }
        
        return heap[0];
    }
    
    private void modifyMinHeap(int[] heap, int n, int i) {
    	int stand = i;
    	
    	while (stand < n) {
    		int initial = stand;
    		int left = stand * 2 + 1;
    		int right = stand * 2 + 2;
    		
    		if (left < n && heap[left] < heap[stand]) {
    			stand = left;
    		}
    		
    		if (right < n && heap[right] < heap[stand]) {
    			stand = right;
    		}
    		
    		if (stand == initial) {
    			break;
    		} else {
    		    changeValue(heap, initial, stand);
    		}
    	}
    }
    
    private void changeValue(int[] nums, int x, int y) {
    	int tmp = nums[x];
    	nums[x] = nums[y];
    	nums[y] = tmp;
    }
    
    public static void main(String[] args) {
    	KthLargestElementInAnArray kObj = new KthLargestElementInAnArray();
    	Scanner cin = new Scanner(System.in);
    	
    	while (cin.hasNext()) {
    		int n = cin.nextInt();
    		int[] nums = new int[n];
    		
    		for (int i = 0; i < n; i ++) {
    			nums[i] = cin.nextInt();
    		}
    		
    		int k = cin.nextInt();
    		
    		int kNum = kObj.findKthLargest(nums, k);
    		
    		System.out.println(kNum);
    	}
    	
    	cin.close();
    }
}
