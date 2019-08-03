package cn.indi;

import cn.indi.example1._02_Singleton;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.junit.Test;

import java.util.concurrent.*;

public class TestSingleton {
    @Test
    public void testSingleton1() {
        _02_Singleton.Singleton1 singleton1 = _02_Singleton.Singleton1.INSTANCE;
        System.out.println(singleton1);//返回的是对象的地址
    }

    @Test
    public void testSingleton2() {
        _02_Singleton.Singleton2 singleton2 = _02_Singleton.Singleton2.INSTANCE;
        System.out.println(singleton2);//返回的是对象的名字
    }

    @Test
    public void testSingleton3() {
        _02_Singleton.Singleton3 singleton3 = _02_Singleton.Singleton3.INSTANCE;
        System.out.println(singleton3);
    }

    @Test
    public void testSingleton4() throws Exception {
        //此方式会有线程不安全问题
//        _02_Singleton.Singleton4 singleton1 = _02_Singleton.Singleton4.getInstance();
//        _02_Singleton.Singleton4 singleton2 = _02_Singleton.Singleton4.getInstance();
//        System.out.println(singleton1);
//        System.out.println(singleton2);
//        System.out.println(singleton1 == singleton2);

        //创建两个线程对象
        Callable<_02_Singleton.Singleton4> callable = _02_Singleton.Singleton4::getInstance;//Lambda方式创建
        ExecutorService service = Executors.newFixedThreadPool(2);//创建两个线程的线程池
        Future<_02_Singleton.Singleton4> future1 = service.submit(callable);
        Future<_02_Singleton.Singleton4> future2 = service.submit(callable);
        _02_Singleton.Singleton4 singleton1 = future1.get();
        _02_Singleton.Singleton4 singleton2 = future2.get();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton1 == singleton2);
        service.shutdown();//关闭线程池
    }
    @Test
    public void testSingleton5() throws Exception {
        //创建两个线程对象
        Callable<_02_Singleton.Singleton5> callable = _02_Singleton.Singleton5::getInstance;//Lambda方式创建
        ExecutorService service = Executors.newFixedThreadPool(2);//创建两个线程的线程池
        Future<_02_Singleton.Singleton5> future1 = service.submit(callable);
        Future<_02_Singleton.Singleton5> future2 = service.submit(callable);
        _02_Singleton.Singleton5 singleton1 = future1.get();
        _02_Singleton.Singleton5 singleton2 = future2.get();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton1 == singleton2);
        service.shutdown();//关闭线程池
    }
    @Test
    public void testSingleton6() throws Exception {
        //创建两个线程对象
        Callable<_02_Singleton.Singleton6> callable = _02_Singleton.Singleton6::getInstance;//Lambda方式创建
        ExecutorService service = Executors.newFixedThreadPool(2);//创建两个线程的线程池
        Future<_02_Singleton.Singleton6> future1 = service.submit(callable);
        Future<_02_Singleton.Singleton6> future2 = service.submit(callable);
        _02_Singleton.Singleton6 singleton1 = future1.get();
        _02_Singleton.Singleton6 singleton2 = future2.get();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton1 == singleton2);
        service.shutdown();//关闭线程池

    }
}
