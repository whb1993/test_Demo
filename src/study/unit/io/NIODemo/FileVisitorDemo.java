package study.unit.io.NIODemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by wanghongbin on 2017/8/29 10:58.
 */
public class FileVisitorDemo {
    public static void main(String[] args) {
        try {
            Files.walkFileTree(Paths.get("F:","JAVA","Workspace"),new SimpleFileVisitor<Path>(){

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("正在访问"+dir+"路径");
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("正在找："+file+"文件");
                    if(file.endsWith("FileVisitorDemo.java")){
                        System.out.println("找到文件");
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
