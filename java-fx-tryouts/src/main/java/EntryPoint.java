
/**
 * @author Vadym Mitin
 */
public class EntryPoint {
    public static void main(String[] args) {

        if (args[0].equals("1")) {
            login.Main.main(null);
        }

        if (args[0].equals("2")) {
            unlock.Unlock.main(null);
        } else sample.Main.main(null);

    }
}
