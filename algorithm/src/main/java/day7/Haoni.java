package day7;

/**
 * 汉诺塔问题
 */
public class Haoni {
    public static void haoni(int n){
        if (n > 0){
            func(n,n,"left","mid","right");
        }
    }
    public static void func(int rest,int down,String from,String help,String to){
        if (rest == 1){
            System.out.println("move " + down + "from " + from+ "to " + to);
        }else {
            func(rest -1, down -1,from,to,help);
            func(1,down,from,to,help);
            func(rest -1,down-1,help,from,to);
        }
    }
    public static void process(int n,String from,String to,String help){
        if(n ==1){
            System.out.println("move 1 from"  +from +"to "+ to);
        }else {
            process(n-1,from,help,to);//第一步：把1到n-1从from挪到help，借助to
            System.out.println("move "+n +"from " +from + "to" + to);//第二步:把n挪到to上
            process(n-1,help,to,from);//第一步：把1到n-1从help挪到to，借助from
        }
    }
}
