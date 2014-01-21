import java.util.ArrayList;


public class UniqueBinarySearchTreesII {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int x) {
            this.val = x;
            this.left = this.right = null;
        }
    }

    public static ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public static ArrayList<TreeNode> generateTrees(int left, int right) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        
        if (left > right) {
            res.add(null);
            return res;
        }
        
        for (int i = left; i <= right; i ++) {
            ArrayList<TreeNode> leftTrees = generateTrees(left, i - 1);
            ArrayList<TreeNode> rightTrees = generateTrees(i + 1, right);
            
            for (int j = 0; j < leftTrees.size(); j ++) {
                for (int k = 0; k < rightTrees.size(); k ++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTrees.get(j);
                    root.right = rightTrees.get(k);
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}
