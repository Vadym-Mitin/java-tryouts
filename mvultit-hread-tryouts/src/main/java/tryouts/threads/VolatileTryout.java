package tryouts.threads;

import static java.lang.System.currentTimeMillis;

/**
 * @author Vadym Mitin
 */
public class VolatileTryout {
    static int fixed = 0;
    static int mobile = 0;

    public static void main(String[] args) {
        new Handler().start();
        new Observer().start();

    }

    private static class Handler extends Thread {
        @Override
        public void run() {
            while (fixed < 5) {
                System.out.println("inc mobiled  = " + ++mobile);
                System.out.println("inc fixed  = " + ++fixed);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static class Observer extends Thread {
        int a = fixed;
        int b = mobile;
        long l = currentTimeMillis();

        @Override
        public void run() {
            while (b < 5) {

                if ((currentTimeMillis() - l) > 8000L) break;

                if (fixed != a) {
                    System.out.println("fixed changed - " + fixed);
                    a = fixed;
                }
                if (mobile != b) {
                    System.out.println("mobile changed - " + mobile);
                    b = mobile;
                }
            }
        }
    }
}
