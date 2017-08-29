package study.unit.io.NIODemo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Date;
import java.util.List;

/**
 * Created by wanghongbin on 2017/8/29 16:00.
 * 文件读取修改属性
 */
public class AttributeViewDemo {
    public static void main(String[] args) throws Exception{
        Path path = Paths.get(".\\src\\study\\unit\\io\\NIODemo\\FilesTest.java");
        BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes basicFileAttributes = basicView.readAttributes();

        System.out.println("创建时间："+new Date(basicFileAttributes.creationTime().toMillis()));
        System.out.println("最后访问："+ basicFileAttributes.lastAccessTime());
        System.out.println("最后修改时间"+basicFileAttributes.lastModifiedTime());
        System.out.println("文件大小"+basicFileAttributes.size());


        FileOwnerAttributeView fileAttributeView = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
        System.out.println("对应用户："+fileAttributeView.getOwner());
        UserPrincipal userPrincipal = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName(fileAttributeView.getOwner().getName());

        UserDefinedFileAttributeView userView = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);

        List<String> attrNames = userView.list();
        for (String attrName : attrNames) {
            ByteBuffer buf = ByteBuffer.allocate(userView.size(attrName));
            userView.read(attrName,buf);
            buf.flip();
            String value = Charset.defaultCharset().decode(buf).toString();
            System.out.println(attrName+"----"+value);

        }
        //userView.write("发行者",Charset.defaultCharset().encode("疯狂"));

        DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        dosView.setReadOnly(false);


    }
}
