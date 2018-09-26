package http_verticle;

public class SenderHandler {
    public static void handle(String s) {
        System.out.println("I receive a response \"" + s + "\"");
    }
}
