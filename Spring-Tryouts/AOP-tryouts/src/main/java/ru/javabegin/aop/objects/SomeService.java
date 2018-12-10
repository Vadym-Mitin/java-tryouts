package ru.javabegin.aop.objects;

import org.springframework.stereotype.Component;

/**
 * @author Vadym Mitin
 */
@Component
public class SomeService {
    public int getIntValue() {
        return 5;
    }

    public double getDoubleValue() {
        return 5.6;
    }
}
