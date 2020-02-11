package com.neuedu.test2.demo2;

import java.util.Scanner;

/**
 * @author ldamei
 * @date 2020/2/11 9:11
 */
public class Test {
    public static void main(String[] args) {
        // 二维数组
        int[][] array = new int[][]{{1,2,3},{4,5,6,7},{8,9,10,11,12}};
//        System.out.println(array[1][2]);

        // switch case语句
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i){
            case 1:
                System.out.println("周一");
                break;
            case 2:
                System.out.println("周二");
                break;
            case 3:
                System.out.println("周三");
                break;
            case 4:
                System.out.println("周四");
                break;
            case 5:
                System.out.println("周五");
                break;
            case 6:
                System.out.println("周六");
                break;
            case 7:
                System.out.println("周日");
                break;
            default:
                System.out.println("不存在");
                break;
        }
    }
}
