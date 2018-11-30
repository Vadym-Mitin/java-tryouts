package message.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextComponentScanMain {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("message.app/contextComponentScan.xml");
      MessageRenderer renderer = context.getBean("simpleMessageRenderer", MessageRenderer.class);
      renderer.render();
   }
}
