package com.neuedu.test2.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ldamei
 * @date 2020/2/10 15:33
 */
public class MybookTest {
    public static void main(String[] args) {

        Mybook[] books = new Mybook[200];
        Mybook mybook = new Mybook("人民的名义",20,"人民日报","李某某","abc");
        Mybook mybook2 = new Mybook("厚黑学",30,"人民日报","张某某","def");
        books[0] = mybook;
        books[1] = mybook2;
//        inputData();
//        print();
        searchName(books,"");
    }

    public static void inputData(ArrayList<Mybook> books){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
    }

    public static void print(ArrayList<Mybook> books){
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }

    public static void searchName(Mybook[] books,String name){
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        for (int i = 0; i < books.length; i++) {
            List list = (List) books[i];
            if(n.equals(list.get(i))){
                System.out.println("shu");
            }else{
                System.out.println("此书不存在");
            }
        }

    }
}
