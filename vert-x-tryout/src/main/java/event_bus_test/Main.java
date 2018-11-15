package event_bus_test;

import io.vertx.core.Launcher;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.ignite.IgniteClusterManager;

/**
 * @author Vadym Mitin
 */
public class Main {
    public static void main(String[] args) {

        ClusterManager clusterManager = new IgniteClusterManager();

        VertxOptions options = new VertxOptions().setClusterManager(clusterManager);
        Vertx.clusteredVertx(options, res -> {
            if (res.succeeded()) {
                Vertx vertx = res.result();
                vertx.deployVerticle(new Consumer());
                vertx.deployVerticle(new Sender());
//                Launcher.executeCommand("run","-"+Consumer.class.getName()+".java");
            } else {
                System.out.println("failde");
            }
        });
    }
}
