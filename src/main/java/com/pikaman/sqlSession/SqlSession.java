package com.pikaman.sqlSession;

import java.util.List;

/**
 * TODO
 *
 * @author : Pikaman
 * @version : 1.0.0
 * @date : 2020/9/10 9:42 下午
 */
public interface SqlSession {

    <E> List<E> selectList(String statementId, Object... params) throws Exception;

    <T> T selectOne(String statementId, Object... params) throws Exception;

    <T> T getMapper(Class<?> mapperClass);
}
