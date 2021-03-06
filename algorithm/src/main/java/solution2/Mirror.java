package solution2;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Mirror {
    public static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void mirror(TreeNode root){
        TreeNode temp = null;
        if (root != null){
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null){
                mirror(root.left);
            }
            if (root.right!= null){
                mirror(root.right);
            }
        }
    }

}
