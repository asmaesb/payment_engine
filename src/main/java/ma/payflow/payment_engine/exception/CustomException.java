package ma.payflow.payment_engine.exception;

/**
 * @author Asmae
 **/
public class CustomException extends RuntimeException {
    public CustomException(String errorMessage) {
        super(errorMessage);
    }
}