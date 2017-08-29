package study.unit.io.NIODemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghongbin on 2017/8/28 10:52.
 * 工具类Files
 */
public class FilesTest {
    public static void main(String[] args) {
        try {
            Files.copy(Paths.get(".\\src\\study\\unit\\io\\NIODemo\\FilesTest.java"),new FileOutputStream("./src/study/unit/io/temp/FilesTest.txt"));
            System.out.println("是否为隐藏文件"+Files.isHidden(Paths.get(".\\src\\study\\unit\\io\\NIODemo\\FilesTest.java")));
            List<String> lines = Files.readAllLines(Paths.get(".\\src\\study\\unit\\io\\NIODemo\\FilesTest.java"), Charset.forName("utf-8"));
           System.out.println(lines);
            System.out.println("大小:"+Files.size(Paths.get(".\\src\\study\\unit\\io\\NIODemo\\FilesTest.java")));
            ArrayList<String> poem = new ArrayList<>();
            poem.add("输入字符串");
            poem.add("输入字符串2");
            Files.write(Paths.get(".\\src\\study\\unit\\io\\temp\\porm.txt"),poem,Charset.forName("gbk"));
           Files.list(Paths.get(".\\src\\study\\unit\\io\\temp")).forEach(path-> System.out.println(path));
           Files.lines(Paths.get(".\\src\\study\\unit\\io\\NIODemo\\FilesTest.java"),Charset.forName("utf-8")).forEach(line-> System.out.println(line));
            FileStore fileStore = Files.getFileStore(Paths.get("C:"));
            System.out.println("C盘总大小："+fileStore.getTotalSpace());
            System.out.println("C盘可用大小："+fileStore.getUsableSpace());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
