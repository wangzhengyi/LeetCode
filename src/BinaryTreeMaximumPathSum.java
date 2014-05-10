
public class BinaryTreeMaximumPathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            this.val = x;
        }
    }
    
    private static int maxValue;
    
    public static int maxPathSum(TreeNode root) {
        maxValue = root == null ? 0 : root.val;
        findPath(root);
        return maxValue;
    }
    
    public static int findPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(findPath(root.left), 0);
        int right = Math.max(findPath(root.right), 0);
        
        maxValue = Math.max(maxValue, root.val + left + right);
        
        int current = Math.max(root.val, Math.max(root.val + left, root.val + right));
                
        return current;
    }
}
