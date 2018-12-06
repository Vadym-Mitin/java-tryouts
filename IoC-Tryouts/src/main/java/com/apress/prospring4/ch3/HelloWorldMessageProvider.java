package com.apress.prospring4.ch3;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
//@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!!";
    }
}
