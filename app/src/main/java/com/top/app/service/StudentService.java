package com.top.app.service;

import com.top.app.core.service.AbstractService;
import com.top.app.core.service.Service;
import com.top.app.model.Student;
import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.text.ParseException;
import java.util.List;

public interface StudentService extends Service<Student> {

    /**
     * 持久化
     * 插入数据（增）
     * @param student
     */
    @Override
    void insert(Student student) throws Exception;

    /**
     * 通过主鍵刪除
     * @param id
     */
    @Override
    void deleteById(String id) throws Exception;

    /**
     * 更新
     * @param model
     */
    @Override
    void update(Student model) throws Exception;


    /**
     * 通过ID查找
     * @param id
     * @return
     */
    @Override
    Student findById(String id) throws Exception;


    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    /**
     * 批量持久化
     * @param students
     */
    @Override
    void insert(List<Student> students) throws Exception;


    /**
     * 批量刪除 eg：ids -> “1,2,3,4”
     * @param ids
     */
    @Override
    void deleteByIds(String ids) throws Exception;


    /**
     * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
     * @param fieldName
     * @param value
     * @return
     * @throws TooManyResultsException
     */
    @Override
    Student findBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * 通过多个ID查找//eg：ids -> “1,2,3,4”
     * @param ids
     * @return
     */
    @Override
    List<Student> findByIds(String ids) throws Exception;

    /**
     * 根据条件查找
     * @param condition
     * @return
     */
    @Override
    List<Student> findByCondition(Condition condition) throws Exception;

    /**
     * 获取所有
     * @return
     */
    @Override
    List<Student> findAll() throws Exception;

}
