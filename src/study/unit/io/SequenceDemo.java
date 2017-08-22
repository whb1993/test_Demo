package study.unit.io;

import com.demo.day04.Person;
import org.junit.Test;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by wanghongbin on 2017/8/22 15:10.
 */
public class SequenceDemo {
    /**
     * * 1.什么是序列流
     * 序列流可以把多个字节输入流整合成一个,
     * 从序列流中读取数据时, 将从被整合的第一个流开始读, 读完一个之后继续读第二个, 以此类推.
     */
    @Test
    public void demoRead(){
        try {
            FileInputStream fis1 = new FileInputStream("./src/study/unit/io/temp/text.txt");			//创建输入流对象,关联a.txt
            FileInputStream fis2 = new FileInputStream("./src/study/unit/io/temp/text1.txt");			//创建输入流对象,关联b.txt
            SequenceInputStream sis = new SequenceInputStream(fis1, fis2);	//将两个流整合成一个流
            FileOutputStream fos = new FileOutputStream("./src/study/unit/io/temp/text2.txt");			//创建输出流对象,关联c.txt

            int b;
            while((b = sis.read()) != -1) {									//用整合后的读
                fos.write(b);												//写到指定文件上
            }

            sis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ###22.02_IO流(序列流整合多个)(了解)
     * 整合多个: SequenceInputStream(Enumeration)
     */
    @Test
    public void demoMore() {
        try {
            FileInputStream fis1 = new FileInputStream("./src/study/unit/io/temp/text1.txt");	//创建输入流对象,关联a.txt
            FileInputStream fis2 = new FileInputStream("./src/study/unit/io/temp/text2.txt");	//创建输入流对象,关联b.txt
            FileInputStream fis3 = new FileInputStream("./src/study/unit/io/temp/text.txt");	//创建输入流对象,关联c.txt
            Vector<InputStream> v = new Vector<>();					//创建vector集合对象
            v.add(fis1);											//将流对象添加
            v.add(fis2);
            v.add(fis3);
            Enumeration<InputStream> en = v.elements();				//获取枚举引用
            SequenceInputStream sis = new SequenceInputStream(en);	//传递给SequenceInputStream构造
            FileOutputStream fos = new FileOutputStream("./src/study/unit/io/temp/text4.txt");
            int b;
            while((b = sis.read()) != -1) {
                fos.write(b);
            }

            sis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ###22.03_IO流(内存输出流*****)(掌握)
     * 1.什么是内存输出流
     * 该输出流可以向内存中写数据, 把内存当作一个缓冲区, 写出之后可以一次性获取出所有数据
     * 2.使用方式
     * 创建对象: new ByteArrayOutputStream()
     * 写出数据: write(int), write(byte[])
     * 获取数据: toByteArray()
     */
    @Test
    public void demoRam() {
        try {
            FileInputStream fis = new FileInputStream("./src/study/unit/io/temp/text.txt");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int b;
            while((b = fis.read()) != -1) {
                baos.write(b);
            }
            // byte[] arr = new byte[5];										//创建字节数组,大小为5
            // int len;
            // while((len = fis.read(arr)) != -1) {							//将文件上的数据读到字节数组中
            //     baos.write(arr, 0, len);									//将字节数组的数据写到内存缓冲区中
            // }

            //byte[] newArr = baos.toByteArray();				//将内存缓冲区中所有的字节存储在newArr中
            //System.out.println(new String(newArr));
            System.out.println(baos);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取对象  失败
     * 22.05
     */
    @Test
    public void demoSerialization() {

        //		FileOutputStream fos = new FileOutputStream("e.txt");
        //		fos.write(p1);
        //		FileWriter fw = new FileWriter("e.txt");
        //		fw.write(p1);
        //无论是字节输出流,还是字符输出流都不能直接写出对象
        try {
            Person p1 = new Person();
            Person p2 = new Person();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/study/unit/io/temp/textDemo.txt"));//创建对象输出流
            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
