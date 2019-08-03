package day3;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基回栈中最小元素的操作。
 * 【要求】
 * 1．pop、push、getMin操作的时间复杂度都是2．设计的栈类型可以使用现成的栈结构。
 */
public class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public MinStack(){
        this.stackData = new Stack <Integer>();
        this.stackMin = new Stack <Integer>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()){//最小栈为空
            this.stackMin.push(newNum);//压入新进来的数
        }else if(newNum < this.getmin()){//新进来的数比栈顶的数小
            this.stackMin.push(newNum);//压入新进来的数
        }else {//min栈的栈顶更小
            int newMin = this.stackMin.peek();//最小的值为栈顶的值
            this.stackMin.push(newMin);//重复压入栈顶的值
        }
        this.stackData.push(newNum);//data栈压入最新的数
    }
    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        this.stackMin.pop();//min栈弹出
        return this.stackData.pop();//pop栈弹出
    }
    public int getmin(){
        if (this.stackMin.isEmpty()){
           throw new RuntimeException("your stack is Empty");
        }
        return this.stackMin.peek();//min栈的栈顶就是最小值
    }

}
