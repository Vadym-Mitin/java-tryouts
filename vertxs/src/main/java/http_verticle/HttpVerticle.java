package http_verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;

/**
 * @author Vadym Mitin
 */
public class HttpVerticle extends AbstractVerticle {

    private static Vertx vertx = Vertx.vertx();
    private static EventBus eventBus = vertx.eventBus();

    public static void main(String[] args) {

        eventBus.consumer("asd", message -> {
            ConsumerHandler.handle((String) message.body());
            message.reply("Hello you!!!!");

        });

        eventBus.send("asd", "Hello!!!!!",
                ar -> {
                    if (ar.succeeded()) {
                        SenderHandler.handle((String) ar.result().body());
                    }
                });

        System.out.println("First this is printed");
    }
}
