/**
 * @author Vadym Mitin
 */
public class Arithmetical {
    public static void main(String[] args) {
        try {
            int x = 0;
            int y = 5 / x;
        } catch (ArithmeticException e) {
            System.out.println("arithmetical");
        } catch (Exception e) {
            System.out.println("exception");
        }
        System.out.println("finish");
    }
}
