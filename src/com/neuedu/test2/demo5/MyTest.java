package com.neuedu.test2.demo5;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * @author ldamei
 * @date 2020/2/13 17:26
 */
public class MyTest {

//    public static ArrayList list = new ArrayList();
    public static List list = new Vector();  // Vector 线程安全

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5000);

        for (int i = 0; i < 5000; i++) {
            Thread t = new Thread(()->{
                list.add(1);
                countDownLatch.countDown();
            });
            t.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
