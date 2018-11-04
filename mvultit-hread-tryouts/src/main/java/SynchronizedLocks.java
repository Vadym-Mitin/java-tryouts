import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Vadym Mitin
 */
public class SynchronizedLocks {

    public static void main(String[] args) throws InterruptedException {
        new Worker().main();
    }

}

class Worker {
    Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    Object lock1 = new Object();
    Object lock2 = new Object();


    private void addToList1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    private void addToList2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    public void work1() {
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void work2() {
        for (int i = 0; i < 1000; i++) {
            addToList2();
//            addToList2();
        }
    }

    public void main() throws InterruptedException {
        long before = System.currentTimeMillis();

        Thread thread1 = new Thread(this::work1);
        Thread thread2 = new Thread(this::work1);

        thread1.start();
        thread2.start();

        thread1.join();
        thread1.join();

        long l = System.currentTimeMillis() - before;
        Thread.sleep(200);
        System.out.println("do ti for time : " + l);
        System.out.println("list1 = " + list1.size());
        System.out.println("list2 = " + list2.size());
    }
}
