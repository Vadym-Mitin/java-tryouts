package event_bus_test;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;

/**
 * @author Vadym Mitin
 */
public class Consumer extends AbstractVerticle {
    @Override
    public void start() {
        EventBus eb = vertx.eventBus();
        eb.consumer("consumer.test", message -> {
            System.out.println("I have received a message: " + message.body());
            message.reply("how interesting!");
        });
        System.out.println("I, Consumer, i was deployed!!!");
    }
}
