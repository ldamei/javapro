package com.neuedu.basic3.demo2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ldamei
 * @date 2020/2/6 13:05
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List list1 = new LinkedList();
        list1.add("3");
        list1.add(23);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }


}
