package com.neuedu.test2.demo4;

/**
 * Thread类：
 *     1.调用run方法并非以线程方式启动，只是调用了一个方法，
 *       要用start方法启动线程，启动线程后，该线程运行起来，入口就是run
 *     2.sleep方法，暂时放弃对 CPU 的抢占
 *
 *    Thread.currentThread()，获取当前运行的线程
 *    线程对象下有一个getName()，返回线程名
 *
 * @author ldamei
 * @date 2020/2/12 23:12
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100 ; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("线程输出："+i);
            System.out.println(Thread.currentThread().getName()+"线程输出："+i);
        }
    }
}
