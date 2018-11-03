/**
 * @author Vadym Mitin
 */
public class SimpleThreadsTryout {
    public static void main(String[] args) {
        System.out.println("the first thread started");
        MyThread myThread = new MyThread("1");
        myThread.start();

        System.out.println("the second thread started");
        MyThread myThread2 = new MyThread("2");
        myThread2.start();
    }

    static class MyThread extends Thread {

        private final String name;

        MyThread(String name) {
            this.name = name;
        }


        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println("Thread name: " + name + "; output = " + i);
            }
        }
    }

}
