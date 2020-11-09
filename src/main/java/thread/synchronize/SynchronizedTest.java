package thread.synchronize;

/**
 * @author: yangj
 * @date: Created in 2020/11/9
 */
public class SynchronizedTest {
    public static void main(String[] args) throws InterruptedException {
        System.err.println("start...");
        Sync sync = new Sync();
        Thread t1 = new Thread(() -> Sync.staticSay("SYNC1"));
        Thread t2 = new Thread(() -> Sync.staticSay("SYNC2"));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.err.println("end...");
    }

}

class Sync {

    public synchronized static void staticSay(String name) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name+ ":   this is static sync...");
    }

    public void Say(String name){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name+ ":   this is sync...");
    }
}
