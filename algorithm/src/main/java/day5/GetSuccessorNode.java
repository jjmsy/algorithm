package day5;

/**
 * 在二叉树中找到一个节点的后继节点.
 *
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。假
 * 设有一 棵Node类型的节点组成的二叉树，树中每个节点的parent指针
 * 都正确地指向 自己的父节点，头节点的parent指向null。只给一个在
 * 二叉树中的某个节点 node，请实现返回node的后继节点的函数。在二
 * 叉树的中序遍历的序列中， node的下一个节点叫作node的后继节点。
 */
public class GetSuccessorNode {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int data){
            this.value = data;
        }
    }
    public static Node getSuccessNode(Node node){
        if (node ==null){
            return node;
        }
        if (node.right != null) {//有右子树
            return getLeftMost(node.right);//返回整个树中最左的节点
        }else {
            Node parent = node.parent;
            //整棵树最右节点为空
            while (parent != null && parent.left != node){//当前节点的父节点为空并且当前节点是自己parent的左孩子了停
                node = parent;
                parent = node.parent;//两行的意思为当前节点和父节点同时往上走
            }
            return parent;
        }
    }
    public static Node getLeftMost(Node node){
        if (node == null) {
            return node;
        }while (node.left != null){//返回整个树中最左的节点
            node = node.left;
        }
        return node;
    }
}
