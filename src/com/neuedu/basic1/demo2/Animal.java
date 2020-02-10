package com.neuedu.basic1.demo2;

/**
 * @author ldamei
 * @date 2020/2/5 14:25
 */
public class Animal {
    private int age;
    private String name;

    public void run(){
        System.out.println("动物在跑");
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
