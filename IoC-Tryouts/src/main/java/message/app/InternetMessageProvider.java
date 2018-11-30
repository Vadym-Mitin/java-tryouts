package message.app;

public class InternetMessageProvider implements MessageProvider {
   @Override
   public String getMessage() {
      return "Message from internet";
   }
}
