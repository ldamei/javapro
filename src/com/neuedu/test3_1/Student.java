package com.neuedu.test3_1;

/**
 * @author ldamei
 * @date 2020/2/20 16:54
 */
public class Student {
    private int id;
    private String name;
    private String classname;
    private int gender;

    public Student() {
    }

    public Student(String name, String classname, int gender) {
        this.name = name;
        this.classname = classname;
        this.gender = gender;
    }

    public Student(int id, String name, String classname, int gender) {
        this.id = id;
        this.name = name;
        this.classname = classname;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classname='" + classname + '\'' +
                ", gender=" + gender +
                '}';
    }
}
