package study.unit.io;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * Created by wanghongbin on 2017/8/21 15:41.
 * 联系IO
 */
public class demoStart {

    @Test
    public void ioDemo(){

        try {
            FileInputStream fis = new FileInputStream("aaa.txt");	//创建一个文件输入流对象,并关联aaa.txt
            int b;													//定义变量,记录每次读到的字节
            while((b = fis.read()) != -1) {							//将每次读到的字节赋值给b并判断是否是-1
                System.out.println(b);								//打印每一个字节
            }

            FileOutputStream fos = new FileOutputStream("aaa.txt");	//如果没有bbb.txt,会创建出一个
            // FileOutputStream fos = new FileOutputStream("aaa.txt",true);	//如果没有bbb.txt,会创建出一个 存在在后面追加

            //fos.write(97);						//虽然写出的是一个int数,但是在写出的时候会将前面的24个0去掉,所以写出的一个byte
            fos.write(110);
            fos.write(99);
            fos.close();

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readToWrite(){
        try {
            FileInputStream fis = new FileInputStream("./src/study/unit/io/temp/kmlg.jpg");	//创建输入流对象,关联致青春.mp3
            FileOutputStream fos = new FileOutputStream("./src/study/unit/io/temp/kmlg_copy.jpg");//创建输出流对象,关联copy.mp3

            //缺陷弊端:效率太低
            // int b;
            // int a = 0 ;//文件字节数  及文件大小
            // while((b = fis.read()) != -1) {
            //     a++;
            //     fos.write(b);
            // }
            // System.out.println(a);

            //缺点可能内存溢出
            // byte[] arr = new byte[fis.available()];					//根据文件大小做一个字节数组
            // System.out.println(arr.length);
            // fis.read(arr);											//将文件上的所有字节读取到数组中
            // fos.write(arr);											//将数组中的所有字节一次写到了文件上

            int len;
            byte[] arr = new byte[1024 * 8];					//自定义字节数组

            while((len = fis.read(arr)) != -1) {
                //fos.write(arr);
                fos.write(arr, 0, len);							//写出字节数组写出有效个字节个数
            }

            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * * A:缓冲思想
     * 字节流一次读写一个数组的速度明显比一次读写一个字节的速度快很多，
     * 这是加入了数组这样的缓冲区效果，java本身在设计的时候，
     * 也考虑到了这样的设计思想(装饰设计模式后面讲解)，所以提供了字节缓冲区流
     * B.BufferedInputStream
     * BufferedInputStream 内置了一个缓冲区(数组)
     * 从BufferedInputStream中读取一个字节时
     * BufferedInputStream会一次性从文件中读取8192个, 存在缓冲区中, 返回给程序一个
     * 程序再次读取时, 就不用找文件了, 直接从缓冲区中获取
     * 直到缓冲区中所有的都被使用过, 才重新从文件中读取8192个
     * C.BufferedOutputStream
     * BufferedOutputStream也内置了一个缓冲区(数组)
     * 程序向流中写出字节时, 不会直接写到文件, 先写到缓冲区中
     * 直到缓冲区写满, BufferedOutputStream才会把缓冲区中的数据一次性写到文件里
     */
    @Test
    public void bufferDemo(){
        try (FileInputStream fis = new FileInputStream("./src/study/unit/io/temp/kmlg1.jpg");		//创建文件输入流对象,关联致青春.mp3
             BufferedInputStream bis = new BufferedInputStream(fis);			//创建缓冲区对fis装饰
             FileOutputStream fos = new FileOutputStream("./src/study/unit/io/temp/kmlg2.jpg");		//创建输出流对象,关联copy.mp3
             BufferedOutputStream bos = new BufferedOutputStream(fos);	)	//创建缓冲区对fos装饰
        // BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.jpg"));
        // BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("b.jpg"));
        {
            int b;
            while((b = bis.read()) != -1) {
                bos.write(b ^ 123);
                //加密，解密用相同方法
                // ^ 双条件
            }

            bis.close();						//只关装饰后的对象即可
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            FileOutputStream fos = new FileOutputStream("./src/study/unit/io/temp/text.txt");
            System.out.println("请输入:");
            while(true) {
                String line = sc.nextLine();
                if("quit".equals(line))
                    break;
                fos.write(line.getBytes());
                fos.write("\r\n".getBytes());
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

