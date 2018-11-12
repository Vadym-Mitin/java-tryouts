package pattern.producer.consumer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Vadym Mitin
 */
public class TryoutWaitNotifyWithQueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue wk = new BlockingQueue();

        Thread thread = new Thread(() -> {

            try {
                wk.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread thread1 = new Thread(() -> {

            try {
                wk.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }

    private static class BlockingQueue {
        private final Queue<Integer> queue = new PriorityQueue<>();
        private Object lock = new Object();
        private final int LIMIT = 10;

        private void producer() throws InterruptedException {
            int count = 0;

            while (true) {

                synchronized (lock) {
                    while (queue.size() == LIMIT) {
                        lock.wait();
                    }
                    queue.add(count++);
                    lock.notify();
                }
            }
        }

        private void consumer() throws InterruptedException {
            int count = 9;
            while (true) {
                synchronized (lock) {
                    while (queue.size() == 0) {
                        lock.wait();
                    }

                    int item = 0;
                    for (int i = 0; i < count; i++) {
                        item = queue.poll();

                    }
                    if (count == 10) {
                        count = 0;
                    }

                    count++;

                    System.out.println(item);
                    System.out.println("queue size  = " + queue.size());

                    lock.notify();
                }
                Thread.sleep(500);
            }

        }
    }
}
