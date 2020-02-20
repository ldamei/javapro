package com.neuedu.test3_1.web;


import com.neuedu.test3_1.Student;
import com.neuedu.test3_1.service.IstudentService;
import com.neuedu.test3_1.service.StudentService;

import java.util.List;
import java.util.Scanner;

/**
 * @author ldamei
 * @date 2020/2/20 16:54
 */
public class StudentWeb {
    IstudentService studentService = new StudentService();

    public void showmain(){
        System.out.println("欢迎使用学生管理系统！");
        System.out.println("请输入数字1~5进行操作：");
        System.out.println("1-----查询");
        System.out.println("2-----添加");
        System.out.println("3-----修改");
        System.out.println("4-----删除");
        System.out.println("5-----退出");
        System.out.println("=====================================");
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n){
            case 1:
                query();

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
            case 5:
                System.exit(0);
                break;
        }
    }

    public void query(){
        // 调用服务层
        List<Student> list = studentService.query();
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println("=====================================");
        showmain();
        input();
    }

    public void add(Scanner scanner){
        System.out.println("请输入要添加的姓名：");
        String name = scanner.next();
        System.out.println("请输入要添加的班级：");
        String classname = scanner.next();
        System.out.println("请输入要添加的性别：（1-男 0-女）");
        int gender = scanner.nextInt();
        Student student = new Student(name,classname,gender);
        // 调用服务层
        studentService.add(student);
        System.out.println("=====================================");
        query();
        showmain();
        input();
    }

    public void update(Scanner scanner){
        System.out.println("请输入要修改的id：");
        int id = scanner.nextInt();
        System.out.println("请输入要修改的姓名：");
        String name = scanner.next();
        System.out.println("请输入要修改的班级：");
        String classname = scanner.next();
        System.out.println("请输入要修改的性别：（1-男 0-女）");
        int gender = scanner.nextInt();
        Student student = new Student(id,name,classname,gender);
        // 调用服务层
        studentService.update(student);
        System.out.println("=====================================");
        query();
        showmain();
        input();
    }

    public void del(Scanner scanner){
        System.out.println("请输入要删除的id：");
        int id = scanner.nextInt();
        // 调用服务层
        studentService.del(id);
        System.out.println("=====================================");
        query();
        showmain();
        input();
    }
}
