package com.neuedu.test3_1.service;

import com.neuedu.test3_1.Student;
import com.neuedu.test3_1.dao.IstudentDao;
import com.neuedu.test3_1.dao.StudentDao;

import java.util.List;

/**
 * @author ldamei
 * @date 2020/2/20 16:54
 */
public class StudentService implements IstudentService {
    IstudentDao studentDao = new StudentDao();

    @Override
    public List<Student> query() {
        return studentDao.query();
    }

    @Override
    public int add(Student student) {
        return studentDao.add(student);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public int del(int id) {
        return studentDao.del(id);
    }
}
