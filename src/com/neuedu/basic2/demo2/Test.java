package com.neuedu.basic2.demo2;

/**
 * @author ldamei
 * @date 2020/2/6 0:57
 */
public class Test {
    public static void main(String[] args) {
        ColaEmployee[] d = new ColaEmployee[3];
        SalariedEmployee a = new SalariedEmployee("刘",6000,7);
        HourlyEmployee b = new HourlyEmployee("李",20,180,8);
        SalesEmployee c = new SalesEmployee("杨",6000,0.2,4);
        d[0] = a;
        d[1] = b;
        d[2] = c;

        for (int i = 0; i < d.length ; i++) {
            System.out.println(d[i].getSalary(1));
        }
    }
}
