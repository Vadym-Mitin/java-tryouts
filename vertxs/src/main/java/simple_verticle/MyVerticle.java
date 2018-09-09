package simple_verticle;

import io.vertx.core.AbstractVerticle;

public class MyVerticle extends AbstractVerticle {

    public static int amount = 0;

    private MyVerticle() {
        amount++;
    }

    public static MyVerticle newInstance() {
        return Single.getInstance();

    }

    @Override
    public void start() throws Exception {
        System.out.println("My verticle started = " + amount);
    }

    @Override
    public void stop() throws Exception {
        System.out.println("My verticle stoped");
    }

    private enum Single {
        SINGLETON();
        private final static MyVerticle MY_VERTICLE = new MyVerticle();

        public static MyVerticle getInstance() {
            return MY_VERTICLE;
        }
    }
}
