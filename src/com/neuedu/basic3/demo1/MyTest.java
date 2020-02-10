package com.neuedu.basic3.demo1;

/**
 * @author ldamei
 * @date 2020/2/6 22:35
 */
public class MyTest {
    public static void main(String[] args) {
        /**
         * 继承父类：extend 父类名
         * 实现接口：implements 父类名
         * 传参多态：参数如果是父类，那么所有子类的对象都可以进行传递
         */
         I3 i3 = new I3();
         I5 i5 = new I5();
         I7 i7 = new I7();
         MainBoard mainBoard = new MainBoard();

         // setCpu 参数需要传Cpu类型
         // i3 i5 i7只要是cpu的子类就可以进行传递
         mainBoard.setCpu(i7);
         mainBoard.method();
    }
}
