package day2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    public static class TreeNode{
        int val ;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList <>();
        Queue<TreeNode> queue = new LinkedList <>();
        if (root == null ){
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left!= null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
            list.add(node.val);
        }
        return list;
    }
}
