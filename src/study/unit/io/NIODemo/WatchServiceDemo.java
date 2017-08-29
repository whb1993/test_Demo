package study.unit.io.NIODemo;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by wanghongbin on 2017/8/29 11:26.
 * 文件修改检测
 */
public class WatchServiceDemo {
    public static void main(String[] args) {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Paths.get("C:/").register(watchService, StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_MODIFY,StandardWatchEventKinds.ENTRY_DELETE);
            while (true){
                WatchKey key = watchService.take();
                for(WatchEvent<?> event :key.pollEvents()){
                    System.out.println(event.context()+"文件发生变化");
                    System.out.println(event.kind()+"事件");
                    boolean reset = key.reset();
                    if(!reset){
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
