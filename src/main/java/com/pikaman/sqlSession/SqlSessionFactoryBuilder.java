package com.pikaman.sqlSession;

import com.pikaman.config.XMLConfigBuilder;
import com.pikaman.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * TODO
 *
 * @author : Pikaman
 * @version : 1.0.0
 * @date : 2020/9/10 8:43 下午
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory built(InputStream in) throws DocumentException, PropertyVetoException {

        // 1、使用dom4j解析配置文件 将解析出来的内容封装到Configuration
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);

        // 2、创建sqlSessionFactory对象 生产 sqlSession
        DefaultSqlSessionFactory sessionFactory = new DefaultSqlSessionFactory(configuration);

        return sessionFactory;
    }
}
