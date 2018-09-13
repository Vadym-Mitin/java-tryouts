package simple_verticle;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;

/**
 * @author Vadym Mitin
 */
public class MainSimple {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        EventBus eventBus = vertx.eventBus();
        eventBus.consumer("address", message -> System.out.println(message.body()));
        eventBus.send("address", "Hello!!!");
    }
}
