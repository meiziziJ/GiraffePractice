package com.practice.ssm.service;

import com.practice.ssm.model.Book;
import com.practice.ssm.model.Student;
import com.practice.ssm.util.PageBean;

import java.util.List;

public interface StudentService {
    int deleteByPrimaryKey(Integer sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> queryListPager(Student student, PageBean pageBean);
}