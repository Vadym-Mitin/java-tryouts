package factory.method;

public class BlackChocolate implements Chocolate {
    private final int price = 15;

    public void printPrice() {
        System.out.println(price);
    }
}