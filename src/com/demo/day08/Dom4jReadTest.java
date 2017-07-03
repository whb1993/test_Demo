package com.demo.day08;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by whb on 2017/6/15.
 * 处理xml的方法W
 */
public class Dom4jReadTest {

    private static final Logger LOGGER = Logger.getLogger("");
    public static void main(String[] args) throws Exception{
        readXml("xmltest.xml");

    }

    static public String readXml(String str) throws Exception{
        Dom4jReadTest test = new Dom4jReadTest();
        FileInputStream file = new FileInputStream(str);
        //创建SAXReader读取器，专门用于读取xml
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        //根据saxReader的read重写方法可知，既可以通过inputStream输入流来读取，也可以通过file对象来读取
        //另外还可以使用DocumentHelper提供的xml转换器也是可以的。
//       Document document = DocumentHelper.parseText("");
        Element rootElement = document.getRootElement();
        test.listNodes(rootElement);
        System.out.println("根节点名称：" + rootElement.getName());//获取节点的名称
        System.out.println("根节点有多少属性：" + rootElement.attributeCount());//获取节点属性数目
        System.out.println("根节点id属性的值：" + rootElement.attributeValue("scanner"));//获取节点的属性scanner的值
//        System.out.println("根节点内文本：" + rootElement.getText());//如果元素有子节点则返回空字符串，否则返回节点内的文本
        //rootElement.getText() 之所以会换行是因为 标签与标签之间使用了tab键和换行符布局，这个也算是文本所以显示出来换行的效果。
        System.out.println("根节点内文本(1)：" + rootElement.getTextTrim());//去掉的是标签与标签之间的tab键和换行符等等，不是内容前后的空格
//        System.out.println("根节点子节点文本内容：" + rootElement.getStringValue()); //返回当前节点递归所有子节点的文本信息。
        //获取子节点
//        Element element = rootElement.element("hostnames");
//        if(element != null){
//            System.out.println("子节点的文本：" + element.getText());//因为子节点和根节点都是Element对象所以它们的操作方式都是相同的
//        }
        //但是有些情况xml比较复杂，规范不统一，某个节点不存在直接java.lang.NullPointerException，所以获取到element对象之后要先判断一下是否为空

//        Iterator<Element> modulesIterator = rootElement.elements("host").iterator();
        //rootElement.element("name");获取某一个子元素
        //rootElement.elements("name");获取根节点下子元素moudule节点的集合，返回List集合类型
        //rootElement.elements("module").iterator();把返回的list集合里面每一个元素迭代子节点，全部返回到一个Iterator集合中
//        while(modulesIterator.hasNext()) {
//            Element moduleElement = modulesIterator.next();
//            Element nameElement = moduleElement.element("address");
//            System.out.println(nameElement.getName() + ":" + nameElement.getText());
//            Element valueElement = moduleElement.element("hostnames");
//            System.out.println(valueElement.getName() + ":" + valueElement.getText());
//            Element descriptElement = moduleElement.element("ports");
//            test.listNodes(descriptElement);
//            System.out.println(descriptElement.getName() + ":" + descriptElement.getText());
//        }
            return "";
   }
    /**
     * 遍历当前节点元素下面的所有(元素的)子节点(属性)
     *
     * @param node
     */
    public void listNodes(Element node) {
        System.out.println("当前节点的名称：：" + node.getName());
        // 获取当前节点的所有属性节点
        List<Attribute> list = node.attributes();
        // 遍历属性节点
        for (Attribute attr : list) {
            System.out.println(
//                    attr.getText() + "-----" +
                            attr.getName()
                    + "=" + attr.getValue());
        }

        if (!(node.getTextTrim().equals(""))) {
            System.out.println("文本内容：：：：" + node.getText());
        }

        // 当前节点下面子节点迭代器
        Iterator<Element> it = node.elementIterator();
        // 遍历
        while (it.hasNext()) {
            // 获取某个子节点对象
            Element e = it.next();
            // 对子节点进行遍历
            listNodes(e);
        }
    }
}


