package com.practice.ssm.service.impl;

import com.practice.ssm.mapper.StudentMapper;
import com.practice.ssm.model.Student;
import com.practice.ssm.service.StudentService;
import com.practice.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-02-15 9:02
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int deleteByPrimaryKey(Integer sid) {
        return this.studentMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public int insert(Student record) {
        return this.studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return this.studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer sid) {
        return this.studentMapper.selectByPrimaryKey(sid);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return this.studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return this.studentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Student> queryListPager(Student student, PageBean pageBean) {
        return this.studentMapper.queryList(student, pageBean);
    }
}
