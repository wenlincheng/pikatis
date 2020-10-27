package com.pikaman.pojo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 核心配置类：对应sqlMapConfig.xml
 *
 * @author : Pikaman
 * @version : 1.0.0
 * @date : 2020/9/10 8:35 下午
 */
public class Configuration {

    private DataSource dataSource;

    // key: statementid value:MappedStatement
    // statementid = namespace.id
    Map<String, MappedStatement> mappedStatementMap = new HashMap<>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }
}
