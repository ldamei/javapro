package com.neuedu.basic1.demo1;

/**
 * @author ldamei
 * @date 2020/2/5 10:32
 */
public class Test2 {
    public static void main(String[] args) {

        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        int a = 30000;
        int index = find(array, a);
        int index2 = search(array, a);
        System.out.println(index);
        System.out.println(index2);
    }

    /**
     * 从 array 中找到 value 的索引
     */
    public static int find(int[] array,int value){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count++;
            if(array[i] == value){
                System.out.println("查找了"+count+"次");
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分搜索
     * 在数组中快速查找元素的一种方式
     * 前提是 必须是有序的数组
     */
    public static int search(int[] array, int value){
        int min = array[0];
        int max = array[array.length - 1];
        int mid;
        int count = 0;
        while(min <= max){
            count++;
            mid = (min + max) / 2;
            if(value == mid){
                System.out.println("查找了"+count+"次");
                return mid;
            }else if(value < mid){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return -1;
    }
}

