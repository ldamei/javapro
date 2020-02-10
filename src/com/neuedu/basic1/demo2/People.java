package com.neuedu.basic1.demo2;

/**
 * @author ldamei
 * @date 2020/2/5 14:25
 */
public class People extends Animal{
    public static void main(String[] args) {

        People p1 = new People();
        p1.setAge(22);
        System.out.println(p1.getAge());
    }
    @Override
    public void run(){
        System.out.println("人能颠着跑");
    }



}
