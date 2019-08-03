package hard3;

import java.util.Stack;

/**
 * 求最大子矩阵的大小
 * 给定一个整形矩阵map，其中的值只有0和1两种，求其中全是1 的所有区域中，最大的矩形区域为1的数量
 * 例如： 1 1 1 0  其中最大的矩形区域为3个1，所以返回3
 * 再如： 1 0 1 1
 *        1 1 1 1
 *        1 1 1 0 其中最大的矩形区域有6个1，所以返回6
 */
public class MaxRectAngle {
    public static int maxRecSize(int[][] map){
        if (map == null || map.length == 0 || map[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];//辅助数组，一共有多少列就生成多少长度
        for (int i = 0; i  < map.length; i++){
            for (int j = 0; j < map[0].length ; j++){
                /**
                 * 例如： help[] 一开始是[0 0 0 0 ]，第0行的数为1 0 1 1
                 * i在第0行的时候,help变为[1 0 1 1]
                 * i在第1行的时候，help变为[2 1 2 2]
                 * i在第2行的时候，help变为[3 2 3 0]
                 */
                height[j] = map[i][j] == 0 ? 0 : height[j] +1;
            }
            maxArea = Math.max(maxRectFromBottom(height),maxArea);
        }
        return maxArea;
    }
    /**
     * 一个数组如果代表直方图的话在这其中找到最大正方形
     * @param height
     * @return
     */
    public static int maxRectFromBottom(int[] height){
        if (height == null || height.length == 0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack <>();//准备一个栈代表单调栈
        for (int i = 0; i < height.length; i++){//遍历数组中的每一个数
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]){//栈不为空并且当前数小于栈顶的值
                int j = stack.pop();//把这个栈的当前位置弹出
                //，当前数好没有放进去，k指当前数的左边界，如果当前数的下面没东西，左边界就是-1，否则左边界就是弹出之后的栈顶
                int k = stack.isEmpty() ? -1 : stack.peek();
                //此时i位置就是右边界，当前在j位置，k位置为左边界
                //(i - k - 1)表示当前扩了多少个格子，乘以当前数的值，即高度
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);//找到全局最大值
            }
            stack.push(i);
        }
        //遍历完之后，结算栈中剩下的东西
        while (!stack.isEmpty()){
            int j = stack.pop();//当前先弹出一个
            int k = stack.isEmpty() ? -1 : stack.peek();//如果下边还有数则左边界就是下边的数，否则是-1
            //右边界统一都是数组的结束位置，即height.length
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);//更新全局最大值
        }
        return maxArea;
    }
}
