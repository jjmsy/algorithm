package day3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列结构实现一个栈结构
 */
public class TwoQueue {
    private Queue<Integer> data;
    private Queue<Integer> help;
    public TwoQueue(){
        data = new LinkedList <Integer>();
        help = new LinkedList <Integer>();
    }
    public void push(int pushInt){//数永远只进data队列
        data.add(pushInt);
    }
    public int peek(){//给用户返回但是不把数抹掉
        if (data.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        while (data.size() != 1){//data队列中只保留一个数
            help.add(data.poll());//其他的数放到help队列
        }
        int res = data.poll();//把剩下的数返回 即最后加进来的数
        help.add(res);
        swap();//help队列变为data队列，重复上述操作
        return res;
    }

    public int pop(){
        if (data.isEmpty()){
            throw new RuntimeException("the stack is empty");
        }
        while (data.size() >1){//不止一个数，data队列中只剩一个数的时候停止
            help.add(data.poll());//把data的数全部放到help队列
        }
        int res = data.poll();
        swap();//help队列变为data队列，继续取出数据
        return res;
    }
    private void swap(){
        Queue<Integer> temp = help;
        help = data;
        data = temp;
    }
}
