package com.neuedu.test2.demo5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 *  问题1：必须要让输出 a ，在循环5000次结束之后
 *     解决:需要用到另一个锁，叫做闭锁 CountDownLatch
 *     CountDownLatch 对象名 = new CountDownLatch(锁的数量);
 *     await()方法，代表阻塞,等待全部锁解开为止。当全部锁都解开后，await()则放行
 *     countdown()方法，每调用一次，代表解开一个锁
 *
 * @author ldamei
 * @date 2020/2/13 13:03
 */
public class MyTest13 {

    public static int a = 0;
    public static Object obj = new Object();

    public static void main(String[] args) {
        // 第一种办法：（1）创建5000个闭锁
        CountDownLatch countDownLatch = new CountDownLatch(5000);
        // 第二种办法：（1）创建2个信号量
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 5000; i++) {
            Thread t = new Thread(()->{
                // 第一种办法：（2）线程同步
                /*synchronized (obj){
                    a++;
                    // 解锁
                    countDownLatch.countDown();
                }*/
                // 第二种办法：（2）
                try {
                    semaphore.acquire();  // 拿一个信号z
                    a++;
                    countDownLatch.countDown();
                    semaphore.release();  // 放一个信号
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
        // 输出a 的时候，此时的 a 并没有等待上面循环5000次
//        System.out.println(a);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }
}
