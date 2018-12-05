package com.apress.prospring4.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Vadym Mitin
 */
public class AnnotationSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/apress/prospring4/ch3/app-context-xml-annotation.xml");
        context.refresh();
        MessageProvider provider = context.getBean("messageProvider", MessageProvider.class);

        System.out.println(provider.getMessage());
    }
}
