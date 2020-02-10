package com.neuedu.basic2.demo2;

/**
 * 按月销售额和提成率拿工资的员工类
 * @author ldamei
 * @date 2020/2/6 0:30
 */
public class SalesEmployee extends ColaEmployee{
    private int msv;  // 月销售额
    private double rate;  // 提成率

    public SalesEmployee(String name,int msv,double rate,int month){
        super(name,month);
        this.msv = msv;
        this.rate = rate;
    }

    @Override
    public double getSalary(int month) {
        return msv*rate;
    }
}
