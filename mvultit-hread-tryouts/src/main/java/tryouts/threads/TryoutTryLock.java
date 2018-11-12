package tryouts.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Vadym Mitin
 */
public class TryoutTryLock {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new MyThread1().start();
        new MyThread2().start();
    }

    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println("Thread 1 start");
            System.out.println("thread 1 worked");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println("Thread 1 released");
        }
    }


    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            System.out.println("thread 2 start");
            while (true) {
                // this is TryLock
                if (lock.tryLock()) {
                    System.out.println("Thread 2 worked");
                    break;
                } else {
                    System.out.println("Thread 2 is waiting");
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Thread 2 released");
        }
    }
}
