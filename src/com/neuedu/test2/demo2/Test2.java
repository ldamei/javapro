package com.neuedu.test2.demo2;

import java.util.*;

/**
 * 生成10个0-100以内不重复的随机数，并完成排序。（要求应用集合框架和排序方法）
 * @author ldamei
 * @date 2020/2/11 10:34
 */
public class Test2 {
    /*private static int a;*/

    public static void main(String[] args) {
        /*method();
//        System.out.println(a);

        int i = 5;
        if(i < 6 || i++ > 5){
            System.out.println(i);
        }*/
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = randomSet(set);
//        System.out.println(list);
        show(list);
    }
    /*public static void method(){
        a++;
    }*/
    public static List<Integer> randomSet(Set<Integer> set){
        while(set.size() < 10){
            int num = new Random().nextInt(100);
            set.add(num);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (Integer i:set) {
            list.add(i);
        }
        Collections.sort(list);
        return list;
    }

    public static void show(List<Integer> list){
        for (Integer i:list) {
            System.out.println(i);
        }
    }
}
