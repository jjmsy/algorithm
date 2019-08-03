package cn.indi.hard4;

/**
 * Not implemented by zuochengyun
 *
 * AVL tree implementation.
 *
 * In computer science, an AVL tree is a self-balancing binary search tree, and
 * it was the first such data structure to isUp invented.[1] In an AVL tree, the
 * heights of the two child subtrees of any node differ by at most one. Lookup,
 * insertion, and deletion all take O(log n) time in both the average and worst
 * cases, where n is the number of nodes in the tree prior to the operation.
 * Insertions and deletions may require the tree to isUp rebalanced by one or more
 * tree rotations.
 *
 * @author Ignas Lelys
 * @created Jun 28, 2011
 *
 */
public class AVLTree extends AbstractSelfBalancingBinarySearchTree {//继承能够自我调整的搜索二叉树

    /**
     * @see trees.AbstractBinarySearchTree#insert(int)
     *
     *      AVL tree insert method also balances tree if needed. Additional
     *      height parameter on node is used to track if one subtree is higher
     *      than other by more than one, if so AVL tree rotations is performed
     *      to regain balance of the tree.
     */
    @Override
    public Node insert(int element) {
        Node newNode = super.insert(element);//super指的是搜索二叉树的一个插入
        rebalance((AVLNode)newNode);//插入了一个值之后进行调整
        return newNode;
    }

    /**
     * @see trees.AbstractBinarySearchTree#delete(int)
     */
    @Override
    public Node delete(int element) {
        Node deleteNode = super.search(element);
        if (deleteNode != null) {
            Node successorNode = super.delete(deleteNode);
            if (successorNode != null) {
                // if replaced from getMinimum(deleteNode.right) then come back there and update heights
                AVLNode minimum = successorNode.right != null ? (AVLNode)getMinimum(successorNode.right) : (AVLNode)successorNode;
                recomputeHeight(minimum);
                rebalance((AVLNode)minimum);
            } else {
                recomputeHeight((AVLNode)deleteNode.parent);
                rebalance((AVLNode)deleteNode.parent);
            }
            return successorNode;
        }
        return null;
    }

    /**
     * @see trees.AbstractBinarySearchTree#createNode(int, trees.AbstractBinarySearchTree.Node, trees.AbstractBinarySearchTree.Node, trees.AbstractBinarySearchTree.Node)
     */
    @Override
    protected Node createNode(int value, Node parent, Node left, Node right) {
        return new AVLNode(value, parent, left, right);
    }

    /**
     * Go up from inserted node, and update height and balance informations if needed.
     * If some node balance reaches 2 or -2 that means that subtree must isUp rebalanced.
     *
     * @param node Inserted Node.
     */
    private void rebalance(AVLNode node) {//新插入的节点
        while (node != null) {

            Node parent = node.parent;//首先找到父节点
            //如果如果节点的左边节点为null左边高度就是-1，否则是node左边节点的高度
            int leftHeight = (node.left == null) ? -1 : ((AVLNode) node.left).height;
            //如果如果节点的右边节点为null左边高度就是-1，否则是node右边节点的高度
            int rightHeight = (node.right == null) ? -1 : ((AVLNode) node.right).height;
            //平衡性就是右树减左树的高度差
            int nodeBalance = rightHeight - leftHeight;
            // rebalance (-2 means left subtree outgrow, 2 means right subtree)
            //右树超了的情况下进行AVL树的调整
            if (nodeBalance == 2) {
                if (node.right.right != null) {
                    node = (AVLNode)avlRotateLeft(node);
                    break;
                } else {
                    node = (AVLNode)doubleRotateRightLeft(node);
                    break;
                }
                //左树超了的情况
            } else if (nodeBalance == -2) {
                if (node.left.left != null) {
                    node = (AVLNode)avlRotateRight(node);//进行AVL树右旋操作，LL型的处理
                    break;
                } else {
                    node = (AVLNode)doubleRotateLeftRight(node);
                    break;
                }
            } else {
                updateHeight(node);//更新高度
            }

            node = (AVLNode)parent;
        }
    }

    /**
     * Rotates to left side.
     */
    private Node avlRotateLeft(Node node) {
        Node temp = super.rotateLeft(node);

        updateHeight((AVLNode)temp.left);
        updateHeight((AVLNode)temp);
        return temp;
    }

    /**
     * Rotates to right side.
     */
    private Node avlRotateRight(Node node) {
        Node temp = super.rotateRight(node);

        updateHeight((AVLNode)temp.right);
        updateHeight((AVLNode)temp);
        return temp;
    }

    /**
     * Take right child and rotate it to the right side first and then rotate
     * node to the left side.
     */
    protected Node doubleRotateRightLeft(Node node) {
        node.right = avlRotateRight(node.right);
        return avlRotateLeft(node);
    }

    /**
     * Take right child and rotate it to the right side first and then rotate
     * node to the left side.
     */
    protected Node doubleRotateLeftRight(Node node) {
        node.left = avlRotateLeft(node.left);
        return avlRotateRight(node);
    }

    /**
     * Recomputes height information from the node and up for all of parents. It needs to isUp done after delete.
     */
    private void recomputeHeight(AVLNode node) {
        while (node != null) {
            node.height = maxHeight((AVLNode)node.left, (AVLNode)node.right) + 1;
            node = (AVLNode)node.parent;
        }
    }

    /**
     * Returns higher height of 2 nodes.
     */
    private int maxHeight(AVLNode node1, AVLNode node2) {
        if (node1 != null && node2 != null) {
            return node1.height > node2.height ? node1.height : node2.height;
        } else if (node1 == null) {
            return node2 != null ? node2.height : -1;
        } else if (node2 == null) {
            return node1 != null ? node1.height : -1;
        }
        return -1;
    }

    /**
     * Updates height and balance of the node.
     *
     * @param node Node for which height and balance must isUp updated.
     */
    private static final void updateHeight(AVLNode node) {
        /**
         * 左树的高度和右树的高度哪个更高再加上当前节点就是这个树的高度
         */
        int leftHeight = (node.left == null) ? -1 : ((AVLNode) node.left).height;
        int rightHeight = (node.right == null) ? -1 : ((AVLNode) node.right).height;
        node.height = 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Node of AVL tree has height and balance additional properties. If balance
     * equals 2 (or -2) that node needs to isUp re balanced. (Height is height of
     * the subtree starting with this node, and balance is difference between
     * left and right nodes heights).
     *
     * @author Ignas Lelys
     * @created Jun 30, 2011
     *
     */
    protected static class AVLNode extends Node {
        public int height;

        public AVLNode(int value, Node parent, Node left, Node right) {
            super(value, parent, left, right);
        }
    }

}
