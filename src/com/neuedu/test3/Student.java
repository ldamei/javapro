package com.neuedu.test3;

import com.neuedu.test3.util.Column;

import java.lang.annotation.ElementType;

/**
 * @author ldamei
 * @date 2020/2/19 9:10
 */
public class Student {
    @Column("id")
    private int idd;
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

    public Student(int idd, String name, String classname, int gender) {
        this.idd = idd;
        this.name = name;
        this.classname = classname;
        this.gender = gender;
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
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
                "idd=" + idd +
                ", name='" + name + '\'' +
                ", classname='" + classname + '\'' +
                ", gender=" + gender +
                '}';
    }
}
