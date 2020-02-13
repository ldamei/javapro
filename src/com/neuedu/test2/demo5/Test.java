package com.neuedu.test2.demo5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ldamei
 * @date 2020/2/13 19:32
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(method(9));
//        System.out.println(method2(3));
//        method3();
        System.out.println(method4(1000));
    }

    /**
     *  输出斐波那契数列，以1、1，开头，后面每一位都是前两位之和 
     *  1、1、2、3、5、8、13、21、34...,计算第 n 个数
     */
    public static int method(int n){
        if (n==1 || n==2){
            return 1;
        }else{
            int f1 = 1;
            int f2 = 1;
            int sum;
            for (int i = 3; i <= n ; i++) {
                sum = f1+f2;
                f1 = f2;
                f2 = sum;
            }
            return f2;
        }
    }

    /**
     * 一个球从100米高度落下，每次落地后反弹到原高度的一半，
     * 求第 n 次落地后，反弹多高？
     */
    public static int method2(int n){
        int a = 100;
        int b;
        for (int i = 1; i <= n; i++) {
            b = a / 2;
            a -= b;
        }
        return a;
    }

    /**
     * 一个整数加100后是一个完全平方数，再加168也是一个完全平方数，该数是多少？
     */
    public static void method3(){
        for (int i = 0; i < 1000; i++) {
            double x = Math.sqrt(i + 100);
            double y = Math.sqrt(i + 100 + 168);

            if (x == (int)x && y == (int)y){
                System.out.println("该数为："+ i);
            }
        }
    }

    /**
     * n个人围坐在一个圈子里，从1开始报数，报到3的时候离开，最后剩下的是第几个人
     */
    public static int method4(int n){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int m = 1;
        while(list.size() > 1){
            if (m != 3){
                int first = list.remove(0);
                list.add(first);
                m++;
            }else {
                list.remove(0);
                m = 1;
            }
        }
        return list.get(0);
    }
}
