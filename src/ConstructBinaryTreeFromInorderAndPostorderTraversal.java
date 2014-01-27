public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int x) {
            this.val = x;
            this.left = this.right = null;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, postorder.length - 1, inorder.length);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inIndex, int postIndex, int len) {
        if (len <= 0) {
            return null;
        } else {
            int count, i;

            for (count = 0, i = inIndex; i < inorder.length; i++, count++) {
                if (inorder[i] == postorder[postIndex]) {
                    break;
                }
            }

            TreeNode root = new TreeNode(postorder[postIndex]);
            root.right =
                    buildTree(inorder, postorder, inIndex + count + 1, postIndex - 1, len - count
                            - 1);
            root.left = buildTree(inorder, postorder, inIndex, postIndex + count - len, count);

            return root;
        }
    }

    public static void main(String args[]) {

    }
}
