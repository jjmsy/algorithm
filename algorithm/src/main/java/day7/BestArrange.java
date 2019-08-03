package day7;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目
 * 的宣讲。 给你每一个项目开始的时间和结束的时间(给你一个数
 * 组，里面 是一个个具体的项目)，你来安排宣讲的日程，要求会
 * 议室进行 的宣讲的场次最多。返回这个最多的宣讲场次。
 */
public class BestArrange {
    public static class Program{
        public int start;
        public int end;
        public Program(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    public static class ProgaramComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;//把结束时间最早的项目排在前面
        }
    }
    public static int bestArrange(Program[] programs,int current){//current是当前时间
        Arrays.sort(programs,new ProgaramComparator());//将左右项目先排好序
        int result = 0;
        for (int i = 0; i < programs.length; i++){
            if ( current < programs[i].start){//当前时间小于这个项目的开始时间
                result++;
                current += programs[i].end;//当前时间变为项目的结束时间
            }
        }
        return result;
    }
}
