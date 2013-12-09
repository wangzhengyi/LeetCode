import java.util.Scanner;

public class PathSum {
    private static char arr[];
    private static int count;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public static TreeNode creatBtree() {
        TreeNode root = null;
        
        if (arr[count++] == '#') {
            root = null;
        } else {
            root = new TreeNode(arr[count - 1] - '0');
            root.left = creatBtree();
            root.right = creatBtree();
        }

        return root;
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            return dfsBtree(root, root.val, sum);
        }
    }
    
    public static boolean dfsBtree(TreeNode root, int total, int sum) {
        if (root.left == null && root.right == null) {
            if (total == sum) {
                return true;
            } else {
                return false;
            }
        } else {
            boolean flagl, flagr;
            flagl = flagr = false;
            
            if (root.left != null) {
                flagl = dfsBtree(root.left, total + root.left.val, sum);
            }
            
            if (root.right != null) {
                flagr = dfsBtree(root.right, total + root.right.val, sum);
            }
            
            return flagl || flagr;
        }
    }
    
    public static void main(String args[]) {
        String str;
        Scanner cin = new Scanner(System.in);
        TreeNode root = null;
        int sum;

        while (cin.hasNext()) {
            str = cin.nextLine();
            sum = cin.nextInt();
            arr = str.toCharArray();
            count = 0;

            root = creatBtree();
            
            if (hasPathSum(root, sum)) {
                System.out.println("存在指定路径！");
            } else {
                System.out.println("不存在指定路径！");
            }
        }

        cin.close();
    }
}
