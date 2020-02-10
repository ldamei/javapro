package com.neuedu.basic2.demo2;

/**
 * 按小时拿工资的员工类
 * @author ldamei
 * @date 2020/2/6 0:29
 */
public class HourlyEmployee extends ColaEmployee {
    private int hourlywage;  // 每小时的工资
    private int hourage;  // 每个月工作的小时数

    public HourlyEmployee(String name,int hourlywage,int hourage,int month) {
        super(name,month);
        this.hourlywage = hourlywage;
        this.hourage = hourage;
    }

    @Override
    public double getSalary(int month) {
        if( hourage <= 160){
            return hourlywage * hourage;
        }else{
            return 160 * hourlywage + (hourage-160) * 1.5 * hourlywage;
        }
    }
}
