package com.neuedu.basic1.demo3;

/**
 * @author ldamei
 * @date 2020/2/5 15:55
 */
public class MyTest {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        for (int i = 1; i <= 100/*11、20、100*/; i++) {
            t1.add(i);
        }
        for (int i = 0; i <t1.getSize(); i++) {
            System.out.println(t1.get(i));
        }

    }


}
