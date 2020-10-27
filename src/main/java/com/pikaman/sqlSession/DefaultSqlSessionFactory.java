package com.pikaman.sqlSession;

import com.pikaman.pojo.Configuration;

/**
 * 创建sqlSessionFactory对象 生产 sqlSession
 *
 * @author : Pikaman
 * @version : 1.0.0
 * @date : 2020/9/10 9:38 下午
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
