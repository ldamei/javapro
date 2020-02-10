package com.neuedu.basic3.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ldamei
 * @date 2020/2/6 11:27
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        list1.add("123");
        list1.add(1);
        list1.add(2.2);
        list1.add(0,100);
        list2.add("234");
        list2.add("345");
        list1.addAll(list2);

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        System.out.println(list1.size());
        System.out.println(list1.contains("123"));
        System.out.println(list1.indexOf(1));
    }
}
