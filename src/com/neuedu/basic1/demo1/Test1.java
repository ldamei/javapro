package com.neuedu.basic1.demo1;

/**
 * @author ldamei
 * @date 2020/2/5 9:34
 */
public class Test1 {

    public static void main(String[] args) {


        int[] array = {1,5,47,28,50,80,64};
        /**
         * 冒泡排序
         */
        for (int i = 0; i < array.length - 1; i++) {
            int flag = 0;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag++;
                }
            }
            if (flag == 0){
                break;
            }
        }

        /**
         * 选择排序
         */
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        /**
         * 输出
         */
        for(int a : array){
            System.out.println(a);
        }
    }
}
