package com.neuedu.test3.web;

import com.neuedu.test3.Student;
import com.neuedu.test3.service.IstudentService;
import com.neuedu.test3.service.StudentService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * @author ldamei
 * @date 2020/2/19 9:14
 */
public class StudentWeb {
    IstudentService studentService = new StudentService();
    public void showmain(){
        System.out.println("1.查询");
        System.out.println("2.添加");
        System.out.println("3.修改");
        System.out.println("4.删除");
        System.out.println("=================");
    }
    public void input(){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i){
            case 1:
                query();
                showmain();
                input();
                break;
            case 2:
                add(scanner);
                break;
            case 3:
                update(scanner);
                break;
            case 4:
                del(scanner);
                break;
            default:
                System.exit(0);
        }

    }
    // 查询
    private void query(){
        // 调用 服务层提供的方法来去访问数据库
        List<Student> list = null;
        try {
            list = studentService.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Student student : list) {
            System.out.println(student);
        }
    }

    // 添加
    private void add(Scanner scanner){
        System.out.println("请输入要添加的名字：");
        String name = scanner.next();
        System.out.println("请输入要添加的班级：");
        String classname = scanner.next();
        System.out.println("请输入性别：（1-男 0-女）");
        int genger = scanner.nextInt();
        Student student = new Student(name,classname,genger);
        // 调用服务层
        studentService.add(student);
        // 显示列表
        query();
    }

    // 修改
    private void update(Scanner scanner){
        System.out.println("请输入要修改的id:");
        int id = scanner.nextInt();
        System.out.println("请输入要修改的名字：");
        String name = scanner.next();
        System.out.println("请输入要修改的班级：");
        String classname = scanner.next();
        System.out.println("请输入要修改性别：（1-男 0-女）");
        int genger = scanner.nextInt();
        Student student = new Student(id,name,classname,genger);
        // 调用服务层，修改方法
        studentService.update(student);
        // 显示列表
        query();
    }

    // 删除
    private void del(Scanner scanner){
        System.out.println("请输入要删除的id:");
        int id = scanner.nextInt();
        // 调用服务层，删除方法
        studentService.del(id);
        // 显示列表
        query();
    }
}
