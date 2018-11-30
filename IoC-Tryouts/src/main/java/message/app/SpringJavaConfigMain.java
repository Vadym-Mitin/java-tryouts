package message.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJavaConfigMain {
   public static void main(String[] args) {
      ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
      MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
      renderer.render();
   }
}
