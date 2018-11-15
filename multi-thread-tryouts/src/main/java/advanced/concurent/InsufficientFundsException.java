package advanced.concurent;

/**
 * @author Vadym Mitin
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
