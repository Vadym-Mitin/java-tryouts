package event_bus_test;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

/**
 * @author Vadym Mitin
 */
public class Sender extends AbstractVerticle {
    private static int i = 0;

    @Override
    public void start() throws Exception {
        EventBus eventBus = vertx.eventBus();
        vertx.setPeriodic(2000, v -> {
            eventBus.send("consumer.test", "Hello Consumer!!!!!!1111 = " + i++);
        });
        System.out.println("I, Sender, i was deployed!!!");
    }
}
