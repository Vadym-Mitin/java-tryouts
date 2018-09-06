package event_bus_test;

import java.util.function.UnaryOperator;

public class Consumer{
    public static void main(String[] args) {
        UnaryOperator.identity();
    }
    static <T> UnaryOperator<T> identity() {
        return t -> t;
    }
    public void getConsumer(){

    }
}
