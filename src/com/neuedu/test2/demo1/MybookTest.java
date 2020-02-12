package com.neuedu.test2.demo1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ldamei
 * @date 2020/2/10 15:33
 */
public class MybookTest {
    public static Mybook[] books = new Mybook[200];
    public static List<Mybook> list = new ArrayList<>();
    public static File file = new File("d:/books");

    public static void main(String[] args) {
        if (!file.exists()){
            inputData(list);
            save();
        }else{
            read();
        }
        menu();
    }

    // 菜单栏
    public static void menu(){
        System.out.println("============");
        System.out.println("请选择你要进行的操作(请输入数字1-5)：");
        System.out.println("1.添加图书");
        System.out.println("2.删除图书");
        System.out.println("3.查找图书");
        System.out.println("4.查看所有");
        System.out.println("5.退出");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n){
            case  1:
                addBook(list);
                break;
            case 2:
                System.out.println("请输入要删除的书名：");
                String deleteName = scanner.next();
                deleteName(list,deleteName);
                break;
            case 3:
                System.out.println("请输入要查看的书名：");
                String searchName = scanner.next();
                searchName(list,searchName);
                break;
            case 4:
                print(list);
                break;
            case 5:
                System.exit(1);
                break;
        }
    }

    // 输入数据
    public static void inputData(List<Mybook> books){
        System.out.println("首次运行系统请输入初始化书籍的数量");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            Mybook mybook = new Mybook("书名"+i,Double.valueOf(String.valueOf(i)),"出版社"+i,"作者"+i,"ISBN"+i);
            books.add(mybook);
        }
    }

    // 打印书
    public static void print(List<Mybook> books){
        System.out.println("============");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        menu();
    }

    // 查找书
    public static void searchName(List<Mybook> books,String name){
        for (int i = 0; i < books.size(); i++) {
            Mybook mybook = books.get(i);
            if(name.equals(mybook.getName())){
                System.out.println("============");
                System.out.println(mybook);
                menu();
                return;
            }
        }
        System.out.println("============");
        System.out.println("此书不存在");
        menu();
    }

    // 删除书
    public static void deleteName(List<Mybook> books,String name){
        for (int i = 0; i < books.size(); i++) {
            Mybook mybook = books.get(i);
            if(name.equals(mybook.getName())){
                books.remove(mybook);
                System.out.println("============");
                System.out.println("此书删除成功");
                System.out.println(mybook);
                menu();
                return;
            }
        }
        System.out.println("============");
        System.out.println("没有此书，删除失败");
        menu();
    }

    // 添加书
    public static void addBook(List<Mybook> books){
        Scanner scanner = new Scanner(System.in);
        System.out.println("============");
        System.out.println("请输入书名：");
        String name = scanner.next();
        System.out.println("请输入价格：");
        Double price = scanner.nextDouble();
        System.out.println("请输入出版社：");
        String press = scanner.next();
        System.out.println("请输入作者：");
        String author = scanner.next();
        System.out.println("请输入ISBN：");
        String ISBN = scanner.next();
        Mybook mybook = new Mybook(name,price,press,author,ISBN);
        books.add(mybook);
        save();
        menu();
    }

    // 存储书
    public static void save(){
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            os =  new FileOutputStream(file);
            oos = new ObjectOutputStream(os);
            oos.writeObject(list);
            oos.flush();
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(oos != null)
                    oos.close();
                if(os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 读取书
    public static void read(){
        InputStream is = null;
        ObjectInputStream ois = null;
        try {
             is = new FileInputStream(file);
             ois = new ObjectInputStream(is);
            list = (List<Mybook>)ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(ois != null)
                    ois.close();
                if(is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
