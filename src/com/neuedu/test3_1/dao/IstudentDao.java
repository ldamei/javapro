package com.neuedu.test3_1.dao;

import com.neuedu.test3_1.Student;

import java.util.List;

/**
 * @author ldamei
 * @date 2020/2/20 17:24
 */
public interface IstudentDao {
    List<Student> query();
    int add(Student student);
    int update(Student student);
    int del(int id);
}
