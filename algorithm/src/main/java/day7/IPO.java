package day7;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 假设 LeetCode 即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，LeetCode希望在 IPO 之前开展一些项目以增加其资本。
 * 由于资源有限，它只能在 IPO 之前完成最多 k个不同的项目。帮助 LeetCode 设计完成最多 k 个不同项目后得到最大总资本的方式。
 *
 * 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。
 * 最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 *
 * 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。
 *
 */
public class IPO {
    public static class Node {//项目
        public int p;//收益
        public int c;//花费
        public Node(int p, int c){
            this.p = p;
            this.c = c;

        }
    }
    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;//谁花费低谁放在顶部的比较器
        }
    }
    public static class MaxProfitComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p -o1.p;//谁受益高谁放在顶部的比较器
        }
    }

    /**
     *
     * @param k 最多有几个项目
     * @param w 初始资金
     * @param profits 利润数组
     * @param capital 花费数组
     * @return 最大总资本
     */
    public static int findMaximizedCapital(int k, int w,int [] profits,int[] capital){
        Node [] nodes = new Node[profits.length];
        for (int i =0; i<profits.length; i++){
            nodes[i] = new Node(profits[i], capital[i]);//生成好所有的而项目
        }
        //准备一个花费谁小谁放在上面的小根堆
        PriorityQueue<Node> minCostQ = new PriorityQueue <>(new MinCostComparator());
        //追呗一个利润谁大谁放在上面的大根堆
        PriorityQueue<Node> maxProfitQ = new PriorityQueue <>(new MaxProfitComparator());
        for (int i =0;i <nodes.length; i++){
            minCostQ.add(nodes[i]);//把所有的项目加到小根堆里去
        }
        for (int i = 0; i <k; i++){//依次做项目，最多做k个
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= w){//小根堆里面的项目所花费的前小于初始资金
                maxProfitQ.add(minCostQ.poll());//弹出按照利润大的放到大根堆里
            }
            if (maxProfitQ.isEmpty()){//所有项目都做完或者资金不够用，小根堆就不会在弹出项目到大根堆
                return w;
            }
            w += maxProfitQ.poll().p;//初始资金加上做完收益最高的项目所获得的利润
        }
            return w;
    }
}
