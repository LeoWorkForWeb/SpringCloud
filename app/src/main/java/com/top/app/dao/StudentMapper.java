package com.top.app.dao;

import com.top.app.model.Student;

public interface StudentMapper {

    /*
    * 增
    * */
    void insert(Student student);

    /**
     * 删
     * 与xml里删除语句id对应
     * @param id
     */
    void deleteById(String id);

    Student queryById(String id);

    void updateById(String id);
}
