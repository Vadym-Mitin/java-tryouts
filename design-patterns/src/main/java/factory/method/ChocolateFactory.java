package factory.method;

/**
 * @author Vadym Mitin
 */
public class ChocolateFactory implements Factory {

    @Override
    public Chocolate create(int flag) {
        switch (flag) {
            case 0:
                return new WhiteChocolate();
            case 1:
                return new BlackChocolate();
            default:
                return null;
        }
    }
}
