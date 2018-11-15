package tryouts.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Vadym Mitin
 */
public class ThreadPool {

    public static void main(String[] args) throws InterruptedException {

        // create the thread pool
        ExecutorService pool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            pool.submit(new Work(i));
        }

        System.out.println("all tasks are submitted");

        // start execution
        pool.shutdown();

        // wait for executing within an hour
        pool.awaitTermination(1, TimeUnit.HOURS);
    }

    private static class Work implements Runnable {

        private final int id;

        private Work(int id) {
            this.id = id;
        }

        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("worker № " + id + "  done");
        }
    }

}
