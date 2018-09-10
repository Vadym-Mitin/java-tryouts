package event_bus_test;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.eventbus.MessageConsumer;

/**
 * @author Vadym Mitin
 */
public class HttpVerticle extends AbstractVerticle {

    private static Vertx vertx = Vertx.vertx();
    private static EventBus eventBus = vertx.eventBus();

    public static void main(String[] args) {


        MessageConsumer<String> consumer = eventBus.consumer("news.uk.sport");

        eventBus.consumer("asd", new Handler<Message<Object>>() {
            @Override
            public void handle(Message<Object> message) {

            }
        });

        eventBus.send("news.uk.sport",
                "Yay! Someone kicked a ball across a patch of grass",
                ar -> {
                    if (ar.succeeded()) {
                        System.out.println("Received reply: " + ar.result().body());
                    }
                });

        long timerID = vertx.setPeriodic(1000,
                id -> System.out.println("And every second this is printed"));

        System.out.println("First this is printed");
    }

    public void handle(Message message) {
        System.out.println("I have received a message: " + message.body());
        message.reply("how interesting!");
    }


}
