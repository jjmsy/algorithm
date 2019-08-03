package sulotion;

import java.util.Scanner;

/**
 * 商店中每种商品都有标价.例如,一朵花的价格是2元.一个花瓶的价格是5元.为了吸引顾客,商店提供了一组优惠商品价.
 * 优惠商品是把一种或多种商品分成一组,并降价销售.例如,3朵花的价格不是6元而是5元.2个花瓶加1朵花的优惠价是10元.
 * 是设计一种算法,计算出某一顾客所购商品应付的最少费用.
 */
class Commodity {
    int number;//购买数量
    int price;//购买价格
}
public class ZuiShaoFeiYongGouWu {
    private static int MAXCODE = 999;//商品编码的最大值
    private static int SALECOMB = 99;//最大优惠商品组合数
    private static int KIND = 5;     //商品种类
    private static int QUANTITY = 5; //购买某种商品数量的最大值

    private static int b;//购买商品种类数
    private static int s;//当前优惠组合数
    private static int[] num = new int[MAXCODE+1];//记录商品编码与商品种类的对应关系
    private static int[] product = new int[KIND+1];//记录不同种类商品的购买数量
    private static int[][] offer = new int[SALECOMB+1][KIND+1];//offer[i][j]: 商品组合的优惠价(i=0)；某种优惠组合中某种商品需要购买的数量(j>0)
    private static Commodity[] purch = new Commodity[KIND+1];//记录不同商品的购买数量和购买价格
    //五维数组，表示最多提供五种商品
    private static int[][][][][] cost = new int[QUANTITY+1][QUANTITY+1][QUANTITY+1][QUANTITY+1][QUANTITY+1];//记录本次购买的总花费


    public static void main(String[] args){
        init();
        comp(1);
        out();
    }

    /**
     * 比较N种优惠价格的最小价格
     * @param i 商品种类数
     */
    private static void comp(int i){
        if(i > b){//i > 需要购买的种类数，即所有的商品种类和数量都已经确定
            minicost();//开始求他们的最小价格
            return;
        }
        for(int j = 0; j<=purch[i].number; j++){
            product[i] = j;
            //i < b的情况下，递归求出每种商品的购买数量，例如商品种类为2的时候，第一次递归求得是第一种商品的购买数量，i+1
            //第二次递归求出第二种商品的购买数量，i+1
            //第三次递归，此时i ==3 程序跳到上面的if
            comp(i+1);
        }
    }
    private static void minicost(){
        int i,j,k,m,n,p,minm;
        minm = 0;
        for(i=1; i<=b; i++){
            //遍历每一种商品，每一种购买商品数量*商品价格 相加得到minm
            minm += product[i]*purch[i].price;//先规定当前不优惠时的购买价格等于最小价格
        }
        /**
         * 遍历每一种组合数，得到的最小价格为优惠组合花费的钱+剩余商品按原价购买的钱
         *
         */
        for(p=1; p<=s; p++){//s是优惠组合数
            i = product[1] - offer[p][1];//需要购买的第一种商品的数量-优惠组合中包含第一种商品的数量
            j = product[2] - offer[p][2];//需要购买的二种商品的数量-优惠组合中包含第二种商品的数量
            k = product[3] - offer[p][3];//需要购买的第三种商品的数量-优惠组合中包含第三种商品的数量
            m = product[4] - offer[p][4];
            n = product[5] - offer[p][5];
            //如果优惠组合花费的钱+剩余商品按原价购买的钱小于minm
            if(i>=0 && j>=0 && k>=0 && m>=0 && n>=0 && cost[i][j][k][m][n]+offer[p][0] < minm)
                minm = cost[i][j][k][m][n] + offer[p][0];//minm变为优惠组合花费的钱+剩余商品按原价购买的钱
        }
        cost[product[1]][product[2]][product[3]][product[4]][product[5]] = minm;

    }


    /**
     * 初始化数据，把该填的都填进去
     */
    private static void init(){
        Scanner input = new Scanner(System.in);
        int i,j,n,p,t,code;
        for(i=0; i<100; i++)
            for(j=0; j<6; j++)
                offer[i][j] = 0;

        for(i=0; i<6; i++){
            purch[i] = new Commodity();
            purch[i].number = 0;
            purch[i].price = 0;
            product[i] = 0;
        }
        System.out.print("请选择购买商品的种类数： ");
        b = input.nextInt();
        System.out.print("输入每种商品的编码、购买数量、价格： ");
        for(i=1; i<=b; i++){
            code = input.nextInt();
            purch[i].number = input.nextInt();
            purch[i].price = input.nextInt();
            num[code] = i;
        }

        System.out.print("输入当前优惠组合数： ");
        s = input.nextInt();
        System.out.print( "第N个数描述优惠商品组合中商品的种类、编号、购买数量、价格:  ");
        for(i=1; i<=s; i++){
            t = input.nextInt();
            for(j=1; j<=t; j++){
                n = input.nextInt();
                p = input.nextInt();
                offer[i][num[n]] = p;
            }
            offer[i][0] = input.nextInt();
        }
    }
    private static void out(){
        System.out.println("得到的最少费用为："+cost[product[1]][product[2]][product[3]][product[4]][product[5]]);
    }
    /**
     * 2
     *
     * 7 3 2
     *
     * 8 2 5
     *
     * 2
     *
     * 1 7 3 5
     *
     * 2 7 1 8 2 10
     */
}

