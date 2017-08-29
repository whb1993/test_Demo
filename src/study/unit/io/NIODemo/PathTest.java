package study.unit.io.NIODemo;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by wanghongbin on 2017/8/28 10:43.
 * 工具类Path
 */
public class PathTest {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        System.out.println("包含路径数:"+path.getNameCount());
        System.out.println("path根路径:"+path.getRoot());
        Path absolutePath = path.toAbsolutePath();
        System.out.println("绝对路径："+absolutePath);
        System.out.println(absolutePath.getNameCount());
        System.out.println(absolutePath.getName(0));
        Path path1 = Paths.get("f:", "JAVA");
        System.out.println(path1);
    }
}
