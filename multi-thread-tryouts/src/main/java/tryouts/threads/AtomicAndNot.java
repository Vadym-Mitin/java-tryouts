package tryouts.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Vadym Mitin
 */
public class AtomicAndNot {
    private int notAtom = 0;

    private int inc = 0;

    private AtomicInteger atom = new AtomicInteger(0);

    private synchronized void increment() {
        inc++;
    }


    public static void main(String[] args) throws InterruptedException {
        new AtomicAndNot().doIt();

    }

    private void doIt() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 start");
            for (int i = 0; i < 1_000_000; i++) {
                notAtom++;
                atom.incrementAndGet();
                increment();
            }
            System.out.println("Thread 1 notAtom = " + notAtom);
            System.out.println("Thread 1 atom = " + atom.get());
            System.out.println("Thread 1 inc = " + inc);
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 start");
            for (int i = 0; i < 1_000_000; i++) {
                notAtom++;
                atom.incrementAndGet();
                increment();
            }
            System.out.println("Thread 2 notAtom = " + notAtom);
            System.out.println("Thread 2 atom = " + atom.get());
            System.out.println("Thread 2 inc = " + inc);
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println();
        System.out.println("after the end of all threads");
        System.out.println("not atom = " + notAtom);
        System.out.println("atom = " + atom.get());
        System.out.println("inc = " + inc);

    }
}
