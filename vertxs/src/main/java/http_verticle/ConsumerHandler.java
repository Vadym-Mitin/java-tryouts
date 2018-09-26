package http_verticle;

public class ConsumerHandler {
    public static void handle(String s) {
        System.out.println("I receive a message \"" + s + "\" and send response");
    }
}
