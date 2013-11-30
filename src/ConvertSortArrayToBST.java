import java.util.*;

public class ConvertSortArrayToBST {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public static TreeNode createBST(int[] num, int bt, int ed) {
        TreeNode root = null;

        if (bt <= ed) {
            int mid = bt + (ed - bt) / 2;
            root = new TreeNode(num[mid]);
            root.left = createBST(num, bt, mid - 1);
            root.right = createBST(num, mid + 1, ed);
        }

        return root;
    }

    public static TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) return null;

        TreeNode root = createBST(num, 0, num.length - 1);

        return root;
    }

    public static void preOrderTraverse(TreeNode root) {
        if (root != null) {
            System.out.printf("%d ", root.val);
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    public static void main(String[] args) {
        int i, n, num[];
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();
            num = new int[n];

            for (i = 0; i < n; i++) {
                num[i] = cin.nextInt();
            }

            Arrays.sort(num);

            TreeNode root = sortedArrayToBST(num);
            preOrderTraverse(root);
            System.out.println();
        }

        cin.close();
    }
}
