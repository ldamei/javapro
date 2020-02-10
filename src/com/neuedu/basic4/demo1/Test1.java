package com.neuedu.basic4.demo1;

/**
 * 把一个数组拆分成两个数组
 *
 * @author ldamei
 * @date 2020/2/7 10:58
 */
public class Test1 {
    public static void main(String[] args) {
        /*int a = 5;
        int b = 10;
//        boolean b1 = a++ == 7 & b++ >= 18;
        boolean b2 = a++ == 7 && b++ >= 18;
        System.out.println(b<<1);*/

        int[] array = new int[10];
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        int m = 0;

        for (int i = 1; i <= array.length; i++) {
            array[i - 1] = i;
//            System.out.println(array[i - 1]);
        }

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = array[m++];
//            System.out.println(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = array[m++];
//            System.out.println(arr2[i]);
        }

    }
}
