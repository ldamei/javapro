package com.neuedu.test2.demo5;

/**
 * 被synchronize包裹的语句,如果要执行，就必须拿到锁旗标,
 * 如果已经被其他线程拿走，就要等待，等待其他线程执行完放开之后再拿
 * 换句话说，被synchronize包裹的语句，一次只被一个线程执行
 *
 * @author ldamei
 * @date 2020/2/13 12:13
 */
public class MyTicket /*extends Thread*/ implements Runnable{
    Object obj = new Object();
    public static int count = 40;

    @Override
    public void run() {
        // 线程同步synchronize（锁旗标（任何一个对象都可以））{ }
        while(count > 0){
            synchronized (obj){
                System.out.println(Thread.currentThread().getName()+"卖出了第"+count+"张票");
                count--;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public /*synchronized*/ void add(){
        while (true) {
            System.out.println("add");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public /*synchronized*/ void del() {
        while (true) {
            System.out.println("del");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
