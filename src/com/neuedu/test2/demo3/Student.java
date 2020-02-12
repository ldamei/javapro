package com.neuedu.test2.demo3;

import java.io.Serializable;

/**
 * @author ldamei
 * @date 2020/2/12 22:19
 */
public class Student implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private Integer id;
    private Integer age;
    private String grade;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                '}';
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
