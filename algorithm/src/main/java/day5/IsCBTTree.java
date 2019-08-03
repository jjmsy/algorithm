package day5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一个数是否为完全二叉树
 */
public class IsCBTTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }
    public static boolean isCBT(Node head){
        if (head == null){
            return true;
        }
        Queue<Node> queue = new LinkedList <>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);//将头节点加入队列
        while (!queue.isEmpty()){
           head = queue.poll();
           l = head.left;//l指向头节点的左子树
           r = head.right;//r指向头结点的右子树
            if(leaf && (l !=null || r!=null) ||//叶节点开启的情况下如果还有左孩子或者右孩子，一定不是完全二叉树
                    (l ==null && r != null)){//有右孩子没有左孩子，一定不是完全二叉树
                return false;
            }
            if (l != null){
                queue.offer(l);
            }
            if (r != null){
                queue.offer(r);
            }else {//有左孩子没有右孩子或者左孩子和右孩子都没有
                leaf = true;//开启叶节点
            }
        }
        return true;
    }
}
