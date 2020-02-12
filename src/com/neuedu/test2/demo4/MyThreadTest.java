package com.neuedu.test2.demo4;

/**
 * 进程：正在运行的程序
 * 线程：线程是进程的一个执行过程
 *       也就是说，一个进程可以包含多个线程（至少也有一个线程）
 *
 * 如何创建多线程？
 *     1.继承 Thread 类
 *     2.实现 Runnable 接口
 *     3.线程池
 *    （如果用继承 Thread 类或者实现 Runnable 接口的方式，那么必须要重写run方法）
 *
 * lambda表达式：匿名内部类的一个实体写法
 *    lambda表达式要求必须有个接口，并且接口中只能有一个抽象方法！！！
 *    匿名内部类：接口和抽象类不能被实例化，但可以new接口或抽象类
 *
 * @author ldamei
 * @date 2020/2/12 23:17
 */
public class MyThreadTest {
    public static void main(String[] args) {
        /*// 1.继承 Thread 类,创建多线程
        MyThread1 mt1 = new MyThread1();
        mt1.start();
        MyThread1 mt11 = new MyThread1();
        mt11.start();

        //2.实现 Runnable 接口,创建多线程
        MyThread2 mt2 = new MyThread2();
        Thread t = new Thread(mt2);
        t.start();*/

        //1
        /*MyInterface jia = new MyJia();
        System.out.println(jia.method(10,2));*/

        //2 匿名内部类
        /*MyInterface mi = new MyInterface() {
            @Override
            public int method(int a, int b) {
                return a+b;
            }
        };
        System.out.println(method(10,2,mi));*/

        //3 匿名内部类
       /* System.out.println(method(10,2,new MyInterface() {
            @Override
            public int method(int a, int b) {
                return a+b;
            }
        }));*/

        //4 lambda表达式
        /*System.out.println(method(10,2,(a,b)->{
            return a+b;
        }));*/

        // 匿名内部类
        /*Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100 ; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"线程输出："+i);
                }
            }
        });
        t.start();*/

        // lambda表达式
        Thread t = new Thread(()-> {
            for (int i = 1; i <= 100 ; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"线程输出："+i);
            }
        });
        t.start();
    }

    public static int method(int a,int b,MyInterface mi){
        return mi.method(a,b);
    }
}
