package day3;

import java.util.Stack;

/**
 * 用栈结构实现队列结构
 */

public class TwoStack {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStack() {
        stackPush = new Stack <Integer>();
        stackPop = new Stack <Integer>();
    }
    public void push(int pushInt){//把新来的数都加进stackPush栈中
        stackPush.push(pushInt);
    }
    public void push(){//将stackPush栈中的数据倒入stackPop栈中
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("the stack is empty");
        }else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }
    public Integer poll(){
        push();
        return stackPop.pop();//将stackPop栈中的数据取出
    }
    public Integer peek(){
        push();
        return stackPop.peek();
    }

}
