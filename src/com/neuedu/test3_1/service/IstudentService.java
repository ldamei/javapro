package com.neuedu.test3_1.service;

import com.neuedu.test3_1.Student;

import java.util.List;

/**
 * @author ldamei
 * @date 2020/2/20 17:05
 */
public interface IstudentService {
    List<Student> query();
    int add(Student student);
    int update(Student student);
    int del(int id);
}
