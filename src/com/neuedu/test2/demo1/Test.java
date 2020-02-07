package com.neuedu.test2.demo1;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 分别用 ArrayList 和 LinkedList 添加10万个元素，对比性能差异
 * 添加之前获取一个当前时间(单位为毫秒)，添加之后获取一个当前时间，用时 = 添加之后 - 添加之前
 * @author ldamei
 * @date 2020/2/6 18:42
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 结论：
         * 1.写时，在尾部添加，两者性能差不多
         * 2.写时，在中间插入，后者比前者性能高很多
         * 3.读时，前者比后者性能高很多
         */
        List arrayList = new ArrayList();
        List linkedList = new LinkedList();

        // 用 ArrayList 循环添加10万个元素
        Date startWriteArray = new Date();  // 获取写开始时间
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);  // 在尾部添加
//            arrayList.add(0,i);  // 在中间插入
        }
        Date endWriteArray = new Date();  // 获取写结束时间
        System.out.println("ArrayList添加元素用时：" + (endWriteArray.getTime() - startWriteArray.getTime()));

        // 用 LinkedList 循环添加10万个元素
        Date startWriteLinked = new Date();  // 获取写开始时间
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);  // 在尾部添加
//            linkedList.add(0,i);   // 在中间插入
        }
        Date endWriteLinked = new Date();  // 获取写结束时间
        System.out.println("LinkedList添加元素用时：" + (endWriteLinked.getTime() - startWriteLinked.getTime()));

        // 用 ArrayList 循环取出10万个元素
        Date startReadArray = new Date();  // 获取读开始时间
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
        Date endReadArray = new Date();  // 获取读结束时间
        System.out.println("ArrayList读取元素用时：" + (endReadArray.getTime() - startReadArray.getTime()));

        // 用 LinkedList 循环取出10万个元素
        Date startReadLinked = new Date();  // 获取读开始时间
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        Date endReadLinked = new Date();  // 获取读结束时间
        System.out.println("LinkedList读取元素用时：" + (endReadLinked.getTime() - startReadLinked.getTime()));
    }
}
