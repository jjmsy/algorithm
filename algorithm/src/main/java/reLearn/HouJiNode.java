package reLearn;

/**
 * 找到一个节点的后继节点
 */
public class HouJiNode {
    public static class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getHouJi(Node head) {
        if (head == null) {
            return null;
        }
        if (head.right != null) {
            return getLeftNode(head.right);
        } else {
            Node parent = head.parent;
            while (parent != null && parent.left != head) {
                head = parent;
                parent = head.parent;
            }
            return parent;
        }

    }

    public static Node getLeftNode(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
