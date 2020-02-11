package com.neuedu.basic2.demo2;

/**
 * 抽象员工类
 * @author ldamei
 * @date 2020/2/6 0:26
 */
public abstract class ColaEmployee {
    private String name;
    private Integer month;

    public ColaEmployee(String name,Integer month) {
        this.name = name;
        this.month = month;
    }

    public abstract Double getSalary(Integer month);
}
