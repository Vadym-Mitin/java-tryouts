package factory.method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vadym Mitin
 */
public class FactoryTryout {
    private static List<Chocolate> list = new ArrayList<>();

    public static void main(String[] args) {
        ChocolateFactory factory = new ChocolateFactory();
        list.add(factory.create(0));
        list.add(factory.create(1));
        list.add(factory.create(0));
        list.add(factory.create(1));

        for (Chocolate chocolate : list) {
            System.out.println(chocolate.toString());
            chocolate.printPrice();
        }

    }
}
