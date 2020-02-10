package com.neuedu.basic1.demo2;

/**
 * @author ldamei
 * @date 2020/2/5 14:25
 */
public class Test {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        a1.run();
        Animal a2 = new People();
        a2.run();
        People p1 = new People();
        p1.run();
        People p2 = new Student();
        p2.run();
    }

}
