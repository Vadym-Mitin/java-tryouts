package message.app;

public class SimpleMain {
   public static void main(String[] args) {
//      message.app.MessageProvider provider = message.app.MessageFactory.getMessageProvider();
      MessageRenderer renderer = MessageFactory.getMessageRenderer();
      renderer.render();
   }
}
