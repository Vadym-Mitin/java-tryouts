package pattern.producer.consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Vadym Mitin
 */
public class TryoutBlockingDequeue {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread1 = new Thread(() -> {
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }

    private static void producer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            queue.put(random.nextInt(100));
        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Thread.sleep(100);
            if (random.nextInt(10) == 5) {
                System.out.println(queue.take());
                System.out.println("queue size is: " + queue.size());
            }
        }
    }

}
