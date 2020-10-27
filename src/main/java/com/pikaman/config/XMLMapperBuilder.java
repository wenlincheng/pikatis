package com.pikaman.config;

import com.pikaman.pojo.Configuration;
import com.pikaman.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * 解析mapper
 *
 * @author : Pikaman
 * @version : 1.0.0
 * @date : 2020/9/10 9:24 下午
 */
public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 解析mapper
     *
     * @param inputStream 输入流
     * @return void
     */
    public void parse(InputStream inputStream) throws DocumentException {
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();

        List<Element> list = rootElement.selectNodes("//select");
        for (Element element : list) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String parameterType = element.attributeValue("parameterType");
            String sqlText = element.getTextTrim();
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParameterType(parameterType);
            mappedStatement.setSql(sqlText);
            String namespace = rootElement.attributeValue("namespace");
            configuration.getMappedStatementMap().put(namespace+"."+id, mappedStatement);
        }
    }

}
