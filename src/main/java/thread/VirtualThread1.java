package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 杨杰
 * <p>
 * Created on 2025/1/4
 */
public class VirtualThread1 {
    public static void main(String[] args) throws InterruptedException {
        var executorService = Executors.newVirtualThreadPerTaskExecutor();
        executorService.submit(() -> {
            System.out.println("hello world");
        });

        //2
        Thread thread = Thread.ofVirtual().start(() -> System.out.println("hello world2"));

        TimeUnit.SECONDS.sleep(1);
    }
}
