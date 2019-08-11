package cn.indi.example1;

public class _06_Varible {
    static int s;//成员变量 类变量
    int i;//成员变量  实例变量
    int j;//成员变量  实例变量
    {
        int i = 1;//非静态代码块 局部变量 i
        i++;
        j++;
        s++;
    }

    public void test(int j) {//形参 局部变量 j
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {//形参 局部变量 args
        _06_Varible varible1 = new _06_Varible();//方法体 局部变量 varible1
        _06_Varible varible2 = new _06_Varible();//方法体 局部变量 varable2
        varible1.test(10);
        varible1.test(20);
        varible2.test(30);
        System.out.println(varible1.i + "," + varible1.j + "," + varible1.s);
        System.out.println(varible2.i + "," + varible2.j + "," + varible2.s);
    }
}
