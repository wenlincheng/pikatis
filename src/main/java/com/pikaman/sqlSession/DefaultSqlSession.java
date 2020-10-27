package com.pikaman.sqlSession;

import com.pikaman.pojo.Configuration;
import com.pikaman.pojo.MappedStatement;

import java.lang.reflect.*;
import java.util.List;

/**
 * TODO
 *
 * @author : Pikaman
 * @version : 1.0.0
 * @date : 2020/9/10 9:43 下午
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object... params) throws Exception{
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
        List<E> list = simpleExecutor.query(configuration, mappedStatement, params);

        return list;
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) throws Exception {
        List<Object> list = selectList(statementId, params);
        if (list.size() == 1) {
            return (T) list.get(0);
        } else {
            throw new RuntimeException("查询结果为空或者返回多条结果");
        }
    }

    /**
     * 获取mapper的代理对象
     *
     * @param mapperClass
     * @throws
     * @return T
     */
    @Override
    public <T> T getMapper(Class<?> mapperClass) {

        Object proxyInstance = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(), new Class[]{mapperClass},
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 底层还是执行JDBC代码
                // 1、 namespace.id = 接口全限定名.方法名
                String methodName = method.getName();
                String className = method.getDeclaringClass().getName();
                String statementId = className + "." + methodName;

                // 2、参数 params:args
                Type genericReturnType = method.getGenericReturnType();

                if (genericReturnType instanceof ParameterizedType) {
                    List<Object> objects = selectList(statementId, args);
                    return objects;
                }

                return selectOne(statementId, args);
            }
        });

        return (T) proxyInstance;
    }
}
