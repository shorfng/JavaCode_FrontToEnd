package com.loto.xml.d.analysis;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo01_Dom4j {
    public static void main(String[] args) {

        try {
            // 1、获取解析器 SAXReader
            SAXReader saxReader = new SAXReader();

            // 2、获得document文档对象
            Document doc = saxReader.read("src/web.xml");

            // 3、获取根元素
            Element rootElement = doc.getRootElement();
            // System.out.println(rootElement.getName());//获取根元素的名称
            // System.out.println(rootElement.attributeValue("version"));//获取根元素中的属性值

            // 4、获取根元素下的子元素
            List<Element> childElements = rootElement.elements();

            // 5、遍历子元素
            for (Element element : childElements) {
                // 判断元素名称是否为servlet的元素
                if ("servlet".equals(element.getName())) {
                    // 获取servlet-name元素
                    Element servletName = element.element("servlet-name");
                    System.out.println(servletName.getText());
                    // 获取servlet-class元素
                    Element servletClass = element.element("servlet-class");
                    System.out.println(servletClass.getText());

                    System.out.println("=======================");
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
