package study.unit.io;

import org.junit.Test;

import java.io.FileReader;

/**
 * Created by wanghongbin on 2017/8/21 16:51.
 * 字符流
 * 字符流是可以直接读写字符的IO流
 * 字符流读取字符, 就要先读取到字节数据, 然后转为字符.
 */
public class FileReaderDemo {
    public FileReaderDemo() {
    }

    @Test
    public void name() throws Exception {
        FileReader fr = new FileReader("aaa.txt");				//创建输入流对象,关联aaa.txt
        int ch;
        while((ch = fr.read()) != -1) {							//将读到的字符赋值给ch
            System.out.println((char)ch);						//将读到的字符强转后打印
        }

        fr.close();												//关流
    }
}
