package com.neuedu.test4.demo1;

import com.neuedu.test3.Student;
import com.neuedu.test3.util.JdbcUtil;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author ldamei
 * @date 2020/2/19 17:31
 */
public class Test1<T> {

    public static void main(String[] args) {
//        System.out.println(add(1,2,3,4,5));
    }

    /**
     * 动态参数：数据类型... 参数名
     *   一个方法中只允许有一个动态参数
     *  动态参数只能在参数列表的最后一个位置上
     */
    public static int add(int b,int... array){
        int sum = 0;
        for (int a : array) {
            sum += a;
        }
        return sum;
    }

    // 泛型
    public void add2(T obj){}
}
