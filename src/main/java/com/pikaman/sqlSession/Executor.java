package com.pikaman.sqlSession;

import com.pikaman.pojo.Configuration;
import com.pikaman.pojo.MappedStatement;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * TODO
 *
 * @author : Pikaman
 * @version : 1.0.0
 * @date : 2020/9/10 10:02 下午
 */
public interface Executor {

    <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;
}
