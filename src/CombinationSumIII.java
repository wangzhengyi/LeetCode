import java.util.ArrayList;
import java.util.List;


public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, new ArrayList<Integer>(), k, n, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> bucket, int k, int n, int sum) {
    	if (bucket.size() == k) {
    		if (sum == n) {
    			res.add(new ArrayList<Integer>(bucket));
    		}    		
    	} else {
    		int x = bucket.isEmpty() ? 1 : bucket.get(bucket.size() - 1) + 1;
    		for (int i = x; i <= 9 && i <= n / (k - bucket.size()); i ++) {
    			if (bucket.size() < k && sum + i <= n) {
    				bucket.add(i);
    				dfs(res, bucket, k, n, sum + i);
    				bucket.remove(bucket.size() - 1);
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	int k = 3, n = 9;
    	
    	CombinationSumIII obj = new CombinationSumIII();
    	
    	List<List<Integer>> res = obj.combinationSum3(k, n);
    	
    	for (List<Integer> list : res) {
    		System.out.println(list);
    	}
    }
}
