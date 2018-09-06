package event_bus_test;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.eventbus.MessageConsumer;

public class MainVerticle extends AbstractVerticle implements Handler<Message<String>> {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        EventBus eventBus = vertx.eventBus();

        MessageConsumer consumer = eventBus.consumer("news.uk.sport");
        consumer.handler(new MainVerticle());

        eventBus.send("news.uk.sport", "Yay! Someone kicked a ball across a patch of grass",
                new Handler<AsyncResult<Message<Object>>>() {
                    @Override
                    public void handle(AsyncResult<Message<Object>> ar) {
                        if (ar.succeeded()) {
                            System.out.println("Received reply: " + ar.result().body());
                        }
                    }
                });

        long timerID = vertx.setPeriodic(1000,
                new Handler<Long>() {
                    @Override
                    public void handle(Long id) {
                        System.out.println("And every second this is printed");
                    }
                });

        System.out.println("First this is printed");
    }

    public void handle(Message message) {
        System.out.println("I have received a message: " + message.body());
        message.reply("how interesting!");
    }


}
