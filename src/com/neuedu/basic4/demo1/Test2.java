package com.neuedu.basic4.demo1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Set、Map
 * @author ldamei
 * @date 2020/2/10 9:56
 */
public class Test2 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(100);
        set.add(50);
        set.add(20);
        set.add(200);
        set.add(1);
        set.add(100);
//        set.add("abc");
        // Set不能通过下标拿，只能用增强for和迭代器拿
        for (Object object:set) {
            System.out.println(object);
        }

        Map<String,String> map = new HashMap<>();
        map.put("001","张三");
        map.put("002","李四");
        map.put("002","王五");
        System.out.println(map.get("001"));

        Set<String> string = map.keySet();
        for (String str:string) {
            System.out.println(map.get(str));
        }

        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);

        Integer a1 = 128;
        Integer b1 = 128;
        System.out.println(a1.intValue() == b1.intValue());

    }
}
