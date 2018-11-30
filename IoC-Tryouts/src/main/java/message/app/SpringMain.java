package message.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
      MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
      renderer.render();
   }
}
