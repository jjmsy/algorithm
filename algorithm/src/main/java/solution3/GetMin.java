package solution3;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class GetMin {
    Stack<Integer> minStack = new Stack <>();
    Stack<Integer> dataStack = new Stack <>();
    public void push(int node) {
        if (minStack.isEmpty()){
            minStack.push(node);
        }else if (node < this.min()){
            minStack.push(node);
        }else {
            int newNode = minStack.peek();
            minStack.push(newNode);
        }
        dataStack.push(node);
    }

    public void pop() {
        if (dataStack.isEmpty()){
            throw new RuntimeException();
        }
        minStack.pop();
        dataStack.pop();
    }

    public int top() {
        if (this.minStack.isEmpty()){
            throw new RuntimeException("your stack is Empty");
        }
        return this.minStack.peek();
    }

    public int min() {
        if (this.minStack.isEmpty()){
            throw new RuntimeException("your stack is Empty");
        }
        return this.minStack.peek();//min栈的栈顶就是最小值
    }
}
