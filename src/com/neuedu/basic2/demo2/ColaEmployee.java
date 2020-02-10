package com.neuedu.basic2.demo2;

/**
 * 抽象员工类
 * @author ldamei
 * @date 2020/2/6 0:26
 */
public abstract class ColaEmployee {
    public String name;
    public int month;

    public ColaEmployee(String name,int month) {
        this.name = name;
        this.month = month;
    }

    public abstract double getSalary(int month);
}
