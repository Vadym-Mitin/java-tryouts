/**
 * @author Vadym Mitin
 */
public class StaticBlockTryout {
    public static void main(String[] args) {
        new Tryout();
    }

    static class Tryout {
        static {
            System.out.println("this is a static block");
        }

        Tryout() {
            System.out.println("this is a constructor");
        }
    }

}
