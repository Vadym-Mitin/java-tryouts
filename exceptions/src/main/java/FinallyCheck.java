public class FinallyCheck {

    public static void main(String[] args) {
        System.out.println(finaly());
    }

    private static String finaly() {
        try {
            System.out.println("try block work");
            thrower();
            return "return block try";
        } catch (Exception e) {
            System.out.println("catch block work");
            return "return block catch";
        } finally {
            System.out.println("finally block work");
            return "return block finally";
        }
    }

    private static void thrower() throws Exception {
        throw new Exception();
    }
}
