package ma.payflow.payment_engine.enums;

import lombok.Getter;

/**
 * @author Asmae
 **/
@Getter
public enum TransactionStatus {
    INITIATED ("INITIATED"),
    PENDING ("PENDING"),
    FAILED ("FAILED") ,
    BLOCKED ("BLOCKED"),
    SUCCESS ("SUCCESS"),
    CANCELED ("CANCELED");

    private final String value;

    TransactionStatus(String value) {
        this.value = value;
    }
}
