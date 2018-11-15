package http_verticle;

public class ConsumerHandler {
    public static String handle(String s) {
        System.out.println("I receive a message \"" + s + "\" and send response");
        return "Hello you!!!!";
    }
}
