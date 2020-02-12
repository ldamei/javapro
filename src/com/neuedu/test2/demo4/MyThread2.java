package com.neuedu.test2.demo4;

/**
 * 实现 Runnable 接口
 * @author ldamei
 * @date 2020/2/12 23:15
 */
public class MyThread2 implements Runnable{
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
