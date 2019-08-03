package cn.indi.hard4;

import java.util.*;

/**
 * 水平面上有 N 座大楼，每座大楼都是矩阵的形状，可以用一个三元组表示 (start, end, height)，
 * 分别代表其在x轴上的起点，终点和高度。大楼之间从远处看可能会重叠，求出 N 座大楼的外轮廓线。
 *
 * 外轮廓线的表示方法为若干三元组，每个三元组包含三个数字 (start, end, height)，
 * 代表这段轮廓的起始位置，终止位置和高度。
 */
public class Building_Outline {
    public static class Node {
        public boolean isUp;//是上还是下
        public int poision;//哪个位置
        public int height;//哪个高度

        public Node(boolean bORe, int position, int height) {
            isUp = bORe;
            poision = position;
            this.height = height;
        }
    }

    public static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.poision != o2.poision) {
                return o1.poision - o2.poision;//位置比较，小的排在前面，打的排在后面
            }
//            if (o1.isUp != o2.isUp) {
//                return o1.isUp ? -1 : 1;
//            }
            return 0;
        }
    }

    public static List<List<Integer>> buildingOutline(int[][] buildings) {
        //生成信息数组，buildings.length是大楼的数量
        Node[] nodes = new Node[buildings.length * 2];//一个大楼拆成两个信息
        for (int i = 0; i < buildings.length; i++) {
            //收集上的信息
            // 上，开始位置，高度
            nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);
            //收集下的信息，i * 2和i * 2+1是为了保证存放位置不重叠
            //下，结束位置，高度
            nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
        }
        /**
         * 不管是开始位置还是结束位置，都按照位置排序
         */
        Arrays.sort(nodes, new NodeComparator());
        /**
         * key是某一个高度，value是这个高度出现的次数
         */
        TreeMap<Integer, Integer> htMap = new TreeMap<>();
        TreeMap<Integer, Integer> pmMap = new TreeMap<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isUp) {//如果当前高度是加一个高度
                if (!htMap.containsKey(nodes[i].height)) {//如果此高度之前没有出现过
                    htMap.put(nodes[i].height, 1);//把高度放进去，出现一次
                } else {//如果不是第一次出现
                    htMap.put(nodes[i].height, htMap.get(nodes[i].height) + 1);//把高度放进去，出现次数+1
                }
            } else {//当前高度是减一个高度
                if (htMap.containsKey(nodes[i].height)) {//如果包含这个高度
                    if (htMap.get(nodes[i].height) == 1) {//如果这个高度出现次数是一次，再下磁频减到0
                        htMap.remove(nodes[i].height);//所以直接remove掉这个高度
                    } else {
                        htMap.put(nodes[i].height, htMap.get(nodes[i].height) - 1);//否则高度的出现次数减1
                    }
                }
            }
            if (htMap.isEmpty()) {
                pmMap.put(nodes[i].poision, 0);//收集每一个位置的最大高度
            } else {
                pmMap.put(nodes[i].poision, htMap.lastKey());
            }
        }
        //利用pmMap生成轮廓线
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int height = 0;//之前的高度
        /**
         * 因为是treeMap是依次升序的，所以在遍历拿出记录的过程中一定是依次升序的
         * 所以一定是位置早的先遍历
         */
        for (Map.Entry<Integer, Integer> entry : pmMap.entrySet()) {
            int curPosition = entry.getKey();
            int curMaxHeight = entry.getValue();
            /**
             * 如果之前的高度不等于当前的最大高度，开始产生轮廓线
             * 之前的高度不等于0，并且现在的高度和之前的高度不一样
             * 一定是之前高度的轮廓线要收尾了
             */
            if (height != curMaxHeight) {
                if (height != 0) {
                    List<Integer> newRecord = new ArrayList<Integer>();
                    newRecord.add(start);
                    newRecord.add(curPosition);
                    newRecord.add(height);
                    res.add(newRecord);
                }
                /**
                 * 如果之前的高度等于0
                 */
                start = curPosition;//一个轮廓开始
                height = curMaxHeight;//之前的高度变成现在最大的高度
            }
        }
        return res;
    }

}
