package com.neuedu.test3.service;

import com.neuedu.test3.Student;
import com.neuedu.test3.dao.IstudentDao;
import com.neuedu.test3.dao.StudentDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ldamei
 * @date 2020/2/19 9:14
 */
public class StudentService implements IstudentService {
    IstudentDao studentDao = new StudentDao();
    @Override
    public List<Student> query() throws SQLException {
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

    @Override
    public Student queryOne(int id) {
        return null;
    }
}
