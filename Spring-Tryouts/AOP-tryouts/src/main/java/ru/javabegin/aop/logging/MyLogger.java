package ru.javabegin.aop.logging;

import org.springframework.stereotype.Component;

/**
 * @author Vadym Mitin
 */
@Component
public class MyLogger {

    public void printValue(Object obj) {
        System.out.println(obj);
    }

    public void init() {
        System.out.println("init");
    }

    public void close() {
        System.out.println("close");
    }

}
