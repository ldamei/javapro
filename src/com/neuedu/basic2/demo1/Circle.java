package com.neuedu.basic2.demo1;

/**
 * 圆类
 * @author ldamei
 * @date 2020/2/6 0:09
 */
public class Circle extends Shape{
    private int radius;

    public Circle(){}
    public Circle(String color,int radius){
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 3.14*radius*radius;
    }

    @Override
    public double getPer() {
        return 2*3.14*radius;
    }

    @Override
    public String showAll() {
        System.out.println("圆面积："+getArea());
        System.out.println("圆周长："+getPer());
        System.out.println("圆颜色："+getColor());
        return null;
    }
}
