package com.loto.xml.d.analysis;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * Author：蓝田_Loto
 * Date：2018-12-29 16:26
 * PageName：a_dom4j.java
 * Function：dom4j解析（XML解析）
 */

public class a_dom4j {
    public static void main(String[] args) throws DocumentException {
        // 获得document
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("JavaWeb_4.3_01_XML/src/main/resources/spring-beans.xsd"));

        // 获得根元素<beans>
        System.out.println("获得根元素<beans>");
        Element rootElement = document.getRootElement();

        // 遍历获得所有子元素。例如：<bean>
        System.out.println("获取子元素");
        List<Element> allBeanElement = rootElement.elements();
        for (Element beanElement : allBeanElement) {
            // 打印元素名
            String childEleName = beanElement.getName();
            System.out.println(childEleName);

            // 获得bean的id和className属性
            String id = beanElement.attributeValue("id");
            String className = beanElement.attributeValue("className");
            System.out.print(id + " , ");
            System.out.println(className);

            // 获得所有<property>子元素
            List<Element> allPropertyElement = beanElement.elements("property");
            for (Element propElement : allPropertyElement) {
                String name = propElement.attributeValue("name");
                String value = propElement.attributeValue("value");

                System.out.print("\t");
                System.out.print(name + " , ");
                System.out.println(value);
            }

        }
    }
}