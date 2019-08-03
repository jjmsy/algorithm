package cn.indi.example1;

/**
 * 父类的初始化<Clinit>()</>
 * （1）j = method()
 * （2）父类的静态代码块
 *
 * 父类的实例化方法：init()
 * （1）super()
 * （2）i = test()
 * （3）父类的构造代码块
 * （4）父类的无参构造
 *
 * 非静态方法前面其实有一个默认的对象this
 * this在构造方法（或inir）他表示的是正在创建的对象，因为这里是在创建子类Son的对象，
 * 所以test执行的是子类重写的test（）方法（面向对象的多态性）
 *
 * 这里i = test()执行的是子类的重写的test()方法
 */
class Father{
    private int i = test();
    private static int j = method();
    static {
        System.out.print("(1)");
    }
    Father(){
        System.out.print("2)");
    }
    {
        System.out.print("3)");
    }
    public int test(){
        System.out.print("4)");
        return 1;
    }
    public static int method(){
        System.out.print("5)");
        return 1;
    }
}

/**
 * 子类的初始化<Clinit>()
 * （1） j = method()
 * （2）子类的静态代码块
 * 初始化子类要先初始化父类
 *
 * 先初始化父类：5）1）
 * 再初始化子类：10）6）
 *
 * 子类实例化方法：
 * （1）super()  9）3）2）
 * （2）i = test()  9）
 * （3）子类的构造代码块  8）
 * （4）子类的无参构造  7）
 *
 * 因为创建了两个Son对象，因此实例初始化方法（init()）执行了两遍
 */
class Son extends Father{
    private int i = test();
    private static int j = method();
    static{
        System.out.print("6)");
    }
    Son(){
//        super();  写或不写都存在，也就是在子类中一定会调用父类的构造方法
        System.out.print("7)");
    }
    {
        System.out.print("8)");
    }
    public int test(){
        System.out.print("9)");
        return 1;
    }
    public static int method(){
        System.out.print("10)");
        return 1;
    }
}
public class _03_ClassInit {
    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println();
        Son s2 = new Son();
    }
}
