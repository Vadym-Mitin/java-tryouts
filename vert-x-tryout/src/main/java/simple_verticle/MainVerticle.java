package simple_verticle;

import io.vertx.core.Vertx;

public class MainVerticle {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(MyVerticle.newInstance());

    }
}
