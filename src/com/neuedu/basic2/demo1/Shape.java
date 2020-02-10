package com.neuedu.basic2.demo1;

/**
 * 图形类
 * @author ldamei
 * @date 2020/2/5 23:56
 */
public abstract class Shape {
    private int area;  // 面积
    private int per;  // 周长
    private String color;  // 颜色

    public String getColor() {
        return color;
    }

    /*public void setColor(String color) {
        this.color = color;
    }*/

    public Shape(){}
    public Shape(String color){
        this.color = color;
    }

    public abstract double getArea();
    public abstract double getPer();
    public abstract String showAll();
}
