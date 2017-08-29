package study.unit.io.NIODemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by wanghongbin on 2017/8/28 10:28.
 */
public class FileLockTest {
    public static void main(String[] args) {
        try(FileChannel channel = new FileOutputStream("./src/study/unit/io/temp/text.txt").getChannel()) {
            FileLock fileLock = channel.tryLock();
            Thread.sleep(10000);
            fileLock.release();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
