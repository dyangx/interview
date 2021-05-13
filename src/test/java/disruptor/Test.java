package disruptor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {

    static int x = 0;

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Task(),1,2, TimeUnit.SECONDS);

    }

    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(x++);
        }
    }
}
