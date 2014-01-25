import java.util.Scanner;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int x) {
            this.val = x;
            this.left = this.right = null;
        }
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        return buildTree(preorder, 0, inorder, 0, preorder.length);
    }

    public static TreeNode buildTree(int[] preorder, int pIndex, int[] inorder, int oIndex, int len) {
        if (len <= 0) {
            return null;
        }
        
        int count = 0;

        for (int i = oIndex; i < inorder.length; i++, count++) {
            if (preorder[pIndex] == inorder[i]) {
                break;
            }
        }

        TreeNode root = new TreeNode(preorder[pIndex]);

        root.left = buildTree(preorder, pIndex + 1, inorder, oIndex, count);
        root.right = buildTree(preorder, pIndex + count + 1, inorder, oIndex + count + 1, len - count - 1);

        return root;
    }

    public static void postTraverse(TreeNode root) {
        if (root != null) {
            postTraverse(root.left);
            postTraverse(root.right);
            System.out.printf("%d ", root.val);
        }
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] preorder = new int[n];
            int[] inorder = new int[n];

            for (int i = 0; i < n; i++) {
                preorder[i] = cin.nextInt();
            }

            for (int i = 0; i < n; i++) {
                inorder[i] = cin.nextInt();
            }

            TreeNode root = buildTree(preorder, inorder);

            postTraverse(root);
            System.out.println();
        }

        cin.close();
    }
}
