package com.top.app.service.impl;


import com.top.app.core.service.AbstractService;
import com.top.app.dao.StudentMapper;
import com.top.app.model.Student;
import com.top.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liyang
 */
@Service
@Transactional
public class StudentServiceImpl extends AbstractService<Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void insert(Student student) {

        studentMapper.insert(student);
    }

    @Override
    public void deleteById(String id) {
        //super.deleteById(id);
        studentMapper.deleteById(id);
    }
}
