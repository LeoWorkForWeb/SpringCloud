package com.top.app.core.service;


import com.top.app.core.mapper.Mapper;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void insert(T model) {
        mapper.insertSelective(model);
    }

    @Override
    public void insert(List<T> models) {
        mapper.insertList(models);
    }

    @Override
    public void deleteById(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    @Override
    public void update(T model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public T queryById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T queryBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<T> queryByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    @Override
    public List<T> queryByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }

    @Override
    public List<T> queryAll() {
        return mapper.selectAll();
    }
}
