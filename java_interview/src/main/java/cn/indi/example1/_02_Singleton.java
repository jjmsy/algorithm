package cn.indi.example1;

import java.io.IOException;
import java.util.Properties;

/**
 * 单利设计模式示例
 */
public class _02_Singleton {
    /**
     * 第一种：饿汉式，在类初始化的时候直接实例化对象，不管你是否需要这个实例化对象都会被创建
     * 1.构造器私有化
     * 2.内部自行创建并用静态变量保存
     * 3.向外提供这个实例
     * 3.为了强调这是一个单例，可以用final修饰
     */
    public static class Singleton1 {
        public static final Singleton1 INSTANCE = new Singleton1();

        private Singleton1() {
        }//构造方法私有化
    }

    /**
     * 第二种：枚举类型：表示该类型的对象是有限的几个
     * 我们可以限定一个，就成了单例
     */
    public enum Singleton2 {
        INSTANCE
    }

    /**
     * 静态代码块的饿汉式
     */
    public static class Singleton3 {
        public static final Singleton3 INSTANCE;
        private String info;

        static {
            Properties properties = new Properties();
            try {
                properties.load(Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));
                INSTANCE = new Singleton3(properties.getProperty("info"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private Singleton3(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        @Override
        public String toString() {
            return "Singleton3{" +
                    "info='" + info + '\'' +
                    '}';
        }
    }

    /**
     * 第二种：懒汉式：延迟创建这个实例化对象
     * 1.构造器私有化
     * 2.用一个静态变量保存这个唯一的实例
     * 3.提供一个静态方法来获取这个实例对象
     */
    public static class Singleton4 {
        private static Singleton4 instance;

        private Singleton4() {
        }

        //当你去调用getInstance方法时才创建实例化对象，因此上面的静态变量不能为public，否则有课鞥会返回null
        public static Singleton4 getInstance() {
            if (instance == null) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new Singleton4();
            }
            return instance;
        }
    }

    /**
     * 用synchronized的方式实现线程安全
     */
    public static class Singleton5 {
        private static Singleton5 instance;

        private Singleton5() {
        }

        public static Singleton5 getInstance() {
            if (instance == null) {//再加一层判断 如果已经创建过就直接返回该对象，提高效率
                synchronized (Singleton5.class) {
                    if (instance == null) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        instance = new Singleton5();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 既能保持延迟加载又线程安全
     * 在内部类被加载初始化时，才创建这个对象
     * 静态内部类不会随着外部类的初始化而初始化，他是要单独去加载和初始化的
     * 因为实在内部类加载和初始化创建的，因此是县城安全的
     */
    public static class Singleton6 {
        private Singleton6() {
        }
        private static class Inner {
            private static final Singleton6 INSTANCE = new Singleton6();
        }
        public static Singleton6 getInstance() {
            return Inner.INSTANCE;
        }
    }
}
