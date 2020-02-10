package com.neuedu.basic2.demo2;

/**
 * 拿固定工资的员工类
 * @author ldamei
 * @date 2020/2/6 0:28
 */
public class SalariedEmployee extends ColaEmployee {
    private int wage;  // 固定工资

    public SalariedEmployee(String name,int wage,int month){
        super(name,month);
        this.wage = wage;
    }

    @Override
    public double getSalary(int month) {
        return wage;
    }
}
