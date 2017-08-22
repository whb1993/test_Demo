package study.unit.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by wanghongbin on 2017/8/21 16:51.
 * 字符流
 * 字符流是可以直接读写字符的IO流
 * 字符流读取字符, 就要先读取到字节数据, 然后转为字符.
 */
public class FileReaderDemo {
    public FileReaderDemo() {
    }

    /**
     * ###21.04_IO流(什么情况下使用字符流)
     * 字符流也可以拷贝文本文件, 但不推荐使用. 因为读取时会把字节转为字符, 写出时还要把字符转回字节.
     * 程序需要读取一段文本, 或者需要写出一段文本的时候可以使用字符流
     * 读取的时候是按照字符的大小读取的,不会出现半个中文
     * 写出的时候可以直接将字符串写出,不用转换为字节数组
     *
     * * 不可以拷贝非纯文本的文件
     * 因为在读的时候会将字节转换为字符,在转换过程中,可能找不到对应的字符,就会用?代替,写出的时候会将字符转换成字节写出去
     * 如果是?,直接写出,这样写出之后的文件就乱了,看不了了
     *
     * @throws Exception
     */
    //读取
    @Test
    public void demoRead() throws Exception {
        FileReader fr = new FileReader("./src/study/unit/io/temp/text.txt");				//创建输入流对象,关联aaa.txt
        int ch;
        while((ch = fr.read()) != -1) {							//将读到的字符赋值给ch
            System.out.println((char)ch);						//将读到的字符强转后打印
        }

        fr.close();												//关流
    }
    //读写文件
    @Test
    public void demoWrite() {
        try {
            FileReader fr = new FileReader("./src/study/unit/io/temp/text.txt");
            FileWriter fw = new FileWriter("./src/study/unit/io/temp/text1.txt");
            int ch;
            while((ch = fr.read()) != -1) {
                fw.write(ch);
            }
            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  LineNumberReader是BufferedReader的子类, 具有相同的功能, 并且可以统计行号
     * 调用getLineNumber()方法可以获取当前行号
     * 调用setLineNumber()方法可以设置当前行号
     */
    @Test
    public void demoLineNumberReader() {
        try {
            LineNumberReader lnr = new LineNumberReader(new FileReader("./src/study/unit/io/temp/text.txt"));
            String line;
            lnr.setLineNumber(100);									//设置行号
            while((line = lnr.readLine()) != null) {
                System.out.println(lnr.getLineNumber() + ":" + line);//获取行号
            }

            lnr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * IO流(使用指定的码表读写字符)
     * FileReader是使用默认码表读取文件, 如果需要使用指定码表读取, 那么可以使用InputStreamReader(字节流,编码表)
     * FileWriter是使用默认码表写出文件, 如果需要使用指定码表写出, 那么可以使用OutputStreamWriter(字节流,编码表)
     */
    @Test
    public void dummy() {
        try {
            BufferedReader br = 									//高效的用指定的编码表读
                    new BufferedReader(new InputStreamReader(new FileInputStream("./src/study/unit/io/temp/text.txt"), "UTF-8"));
            BufferedWriter bw = 									//高效的用指定的编码表写
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./src/study/unit/io/temp/text.txt"), "GBK"));
            int ch;
            while((ch = br.read()) != -1) {
                bw.write(ch);
            }

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
