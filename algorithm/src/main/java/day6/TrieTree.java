package day6;

public class TrieTree {
    public static class TrieNode {
        public int path;//有多少个字符串是以该字符串为前缀
        public int end;//有多少个字符串是以这个节点结尾的
        public TrieNode[] nexts;//路径

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26];//强行规定路径就是小写字母a~z
        }
    }

    public static class Trie {
        private TrieNode root;//准备头节点

        public Trie() {
            root = new TrieNode();//初始化头节点
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();//转成字符类型的数组
            TrieNode node = root;//从头节点开始
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';//得到的字符减去'a'的ASC码 如'a'-'a'=0
                if (node.nexts[index] == null) {//判断当前node有没有走向当前字符的路
                    node.nexts[index] = new TrieNode();//建立出走向当前字母的路
                }
                node = node.nexts[index];//node往下跳一个节点
                node.path++;
            }
            node.end++;//拿到的是以最后一个node结尾的，所以end++
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].path == 0) {//如果有一个节点的path--变为0
                        node.nexts[index] = null;//下一个节点直接变为null
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        public int search(String word) {//查询一个word在其中出现了几次
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {//如果在任何一步出现null了说明没出现过这个word
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public int prefixNumber(String pre) {//查某一个字符串的前缀数量
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));

    }
}
