package com.neuedu.test3.service;

import com.neuedu.test3.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ldamei
 * @date 2020/2/19 9:27
 */
public interface IstudentService {
    List<Student> query() throws SQLException;
    int add(Student student);
    int update(Student student);
    int del(int id);
    Student queryOne(int id);
}
