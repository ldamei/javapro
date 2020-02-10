package com.neuedu.basic4.demo1;

/**
 * @author ldamei
 * @date 2020/2/10 11:10
 */
public class ScannerTest {
    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
        String str = scanner.nextLine();
        System.out.println(*//*"a="+a+*//*"str="+str);*/

        method();
        String str = method();
        System.out.println(str);
//        System.exit(0);
    }

    public static String method() /*throws Exception*/{
        try {
//            int a = 100/0;
            return "abc";
        }catch (Exception ex){
            return "def";
        }finally {
            System.out.println("无论如何都执行");
        }
    }
}
