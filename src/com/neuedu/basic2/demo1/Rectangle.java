package com.neuedu.basic2.demo1;

/**
 * 矩形类
 * @author ldamei
 * @date 2020/2/6 0:04
 */
public class Rectangle extends Shape{
    private int width;
    private int height;

    public Rectangle(){}
    public Rectangle(String color,int width,int height){
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPer() {
        return 2*(width+height);
    }

    @Override
    public String showAll() {
        System.out.println("矩形面积："+getArea());
        System.out.println("矩形周长："+getPer());
        System.out.println("矩形颜色："+getColor());
        return null;
    }
}
