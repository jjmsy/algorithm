package day5;

/**
 * 已知一棵完全二叉树，求其节点的个数
 * 要求：时间复杂度低于O(N)，N为这棵树的节点个数
 */
public class CompleteTreeNodeNumber {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /**
     * @param node 当前节点
     * @param l 当前节点在第几层
     * @param h 整个数的深度，是一个固定值
     * @return 以node为节点的子树一共有多少个节点
     */
    public static int bs(Node node, int l, int h) {
        if (l == h) {//如果level就是最后一层，即叶节点，整棵树的节点数是一个
            return 1;
        }
        if (mostLeftLevel(node.right, l + 1) == h) {//判断右子树的左边界到没到总体的深度
            /**
             * 右子树的左边界到h了，则左子树必然是一个满二叉树
             * 1 << (h - l)) 是左树的节点个数加当前的节点之后的节点总数
             * 1 << (h - l))2的h-1次方的意思
             * bs(node.right, l + 1, h)是右子树以递归的方式求出他的节点个数
             * 然后两者相加就是整个完全二叉树的总结点数
             */
            return (1 << (h - l)) + bs(node.right, l + 1, h);
        } else {
            /**
             * 右子树的左边界没到h，所以右树的高度要比左树的高度少一个，必然是满二叉树，用1 << (h - l - 1))求解
             * 左子树通过递归的方式求出节点个数
             * 两者相加就是整个完全二叉树的总结点数
             */
            return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
        }
    }

    /**
     *
     * @param node 头节点
     * @param level 头节点依次往下走
     * @return 这个树最左的边界是多少层
     */
    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;//头节点往左走一直走到null
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }
}
