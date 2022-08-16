package thread.threadlocal;

/**
 * @author: yangj
 * @date: Created in 2020/11/9
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        Thread thread;

        ThreadLocal threadLocal = null;


        ThreadLocal<Integer> t = new ThreadLocal<>();
        t.set(0);

        Thread thread1 = new Thread(()->{
            ThreadLocal<Integer> t1 = new ThreadLocal<>();
            t1.set(1);
        });
        Thread thread2 = new Thread(()->{
            ThreadLocal<Integer> t1 = new ThreadLocal<>();
            t1.set(1);
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        int s = t.get();
        System.out.println(s);
    }
}
