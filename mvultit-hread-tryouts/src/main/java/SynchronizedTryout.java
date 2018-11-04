
/**
 * @author Vadym Mitin
 */
public class SynchronizedTryout {
    private int counter;
    private int notCount;

    public synchronized int getCounter() {
        return counter;
    }

    public synchronized void setCounter() {
        this.counter++;
    }

    public static void main(String[] args) throws InterruptedException {

        SynchronizedTryout tryout = new SynchronizedTryout();
        tryout.sync();
        Thread.sleep(2000);
        tryout.notSync();
    }

    void notSync() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                notCount++;
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                notCount++;
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("not sync = " + notCount);
    }

    void sync() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                setCounter();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                setCounter();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("sync = " + getCounter());
    }
}
