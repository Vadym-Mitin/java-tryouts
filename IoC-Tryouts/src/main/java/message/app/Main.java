package message.app;

public class Main {
   public static void main(String[] args) {
//      message.app.MessageProvider provider = message.app.MessageFactory.getMessageProvider();
      MessageRenderer renderer = MessageFactory.getMessageRenderer();
      renderer.render();
   }
}
