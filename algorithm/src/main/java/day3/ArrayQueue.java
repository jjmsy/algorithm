package day3;

/**
 * 用数组结构实现大小固定的队列
 */
public class ArrayQueue {
    private Integer[] arr;
    private Integer size;
    private Integer start;
    private Integer end;
    public ArrayQueue(int initSize){
        if (initSize <0){
            throw new IllegalArgumentException("the initSize is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
        start = 0;
        end = 0;
    }

    public Integer peek(){
        if (size ==0){
            return null;
        }
        return arr[start];
    }

    public void push(int obj) {//假如一个数
        if (size == arr.length){
            throw new ArrayIndexOutOfBoundsException("the queue is full");
        }
        size++;
        arr[end] = obj;
        end = end == arr.length -1 ? 0: end+1;//如果end的下标到底了，数加到开头位置，否则加到下一个位置
    }
    public Integer poll(){//取出一个数
        if (size ==0){//说明队列里已经没有数了
            throw new ArrayIndexOutOfBoundsException("the queue is full");
        }
        size--;
        int temp = start;//start的位置用temp记录一下，因为start的位置要调整
        start = start == arr.length-1 ? 0 : start + 1;
        return arr[temp];
    }
}
