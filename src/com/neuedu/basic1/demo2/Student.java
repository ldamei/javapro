package com.neuedu.basic1.demo2;

/**
 * @author ldamei
 * @date 2020/2/5 14:25
 */
public class Student extends People{

    private int number;
    public Student(){}

    @Override
    public  void run(){
        System.out.println("学生跑");
    }
}
