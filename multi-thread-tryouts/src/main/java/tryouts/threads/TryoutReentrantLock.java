package tryouts.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Vadym Mitin
 */
public class TryoutReentrantLock {

    public static void main(String[] args) throws InterruptedException {
        Resource res = new Resource();
        MyThread t1 = new MyThread(res, "one");
        MyThread t2 = new MyThread(res, "two");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
        System.out.println(res.inter);
        System.out.println(res.jakster);


    }

    private static class MyThread extends Thread {
        Resource resource;
        String name;

        public MyThread(Resource resource, String name) {
            this.resource = resource;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
//                resource.lock.lock();
                resource.change();
                resource.change2();
//                resource.lock.unlock();
            }
        }
    }


}

class Resource {
    int inter = 0;
    int jakster = 0;
    Lock lock = new ReentrantLock();

    void change() {
        lock.lock();
        int i = this.inter;
        i++;
        this.inter = i;
//        lock.unlock();
    }

    void change2() {
//        lock.lock();
        int j = this.jakster;
        j++;
        this.jakster = j;
        lock.unlock();
    }


}