package day3;

/**
 * 用数组结构实现大小固定的栈
 */
public class ArrayStack {
    private Integer[] arr;//数组
    private Integer index;//数组下标
    public ArrayStack(Integer initSize){//给定一个初始的大小
        if (initSize < 0){
            throw new IllegalArgumentException("the initSize is less than 0");
        }
        arr = new Integer[initSize];//当前数组为长度为initSize的数组
        index = 0;//当前数组下标为0
    }
    public Integer peek(){//返回栈顶
        if (index ==0){
            return null;
        }
        return arr[index - 1];
    }
    public void push(int obj){
        if (index == arr.length){//栈中存满数据
            throw new ArrayIndexOutOfBoundsException(" the queue is full");
        }
        arr[index ++] = obj;//index的位置把新来的数填上然后index++
    }
    public Integer pop(){//弹出数据
        if (index ==0 ){//没有数据
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        }
        return arr[-- index];//把index-1位置的数给用户
    }
}
