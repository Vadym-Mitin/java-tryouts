package factory.method;

public class WhiteChocolate implements Chocolate {
    private final int price = 10;

    public void printPrice() {
        System.out.println(price);
    }
}