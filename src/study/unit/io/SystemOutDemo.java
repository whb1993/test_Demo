package study.unit.io;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * Created by wanghongbin on 2017/8/23 11:12.
 */
public class SystemOutDemo {


    /**
     * 	* 打印: print(), println()
     * 自动刷出: PrintWriter(OutputStream out, boolean autoFlush, String encoding)
     * 打印流只操作数据目的
     */
    @Test
    public void sout(){
        PrintStream ps = System.out;
        ps.println(97);					//其实底层用的是Integer.toString(x),将x转换为数字字符串打印
        ps.println("xxx");
        ps.println(new Student("张三", 23));
        Student p = null;
    }

/**
 * * 1.什么是标准输入输出流(掌握)
 * System.in是InputStream, 标准输入流, 默认可以从键盘输入读取字节数据
 * System.out是PrintStream, 标准输出流, 默认可以向Console中输出字符和字节数据
 * 2.修改标准输入输出流(了解)
 * 修改输入流: System.setIn(InputStream)
 * 修改输出流: System.setOut(PrintStream)
 */
    @Test
    public void modify() {
        try {
            System.setIn(new FileInputStream("./src/study/unit/io/temp/text.txt"));				//修改标准输入流
            System.setOut(new PrintStream("./src/study/unit/io/temp/modify.txt"));				//修改标准输出流
            System.out.println("试一试啊");
            InputStream in = System.in;								//获取标准输入流
            PrintStream ps = System.out;							//获取标准输出流
            int b;
            while((b = in.read()) != -1) {							//从a.txt上读取数据
                ps.write(b);										//将数据写到b.txt上
            }
            System.out.println("试一试啊");

            in.close();
            ps.close();
            //System.setOut(new PrintStream(System.out.printf()));
            System.out.println("试一试啊");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * _IO流(两种方式实现键盘录入)(了解)
     * A:BufferedReader的readLine方法。
     * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     * B:Scanner
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入:");
        while(true) {
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(line);
            if("quit".equals(line))
                break;
        }
    }
}
