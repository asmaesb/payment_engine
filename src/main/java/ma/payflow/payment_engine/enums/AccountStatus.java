package ma.payflow.payment_engine.enums;

import lombok.Getter;

/**
 * @author Asmae
 **/
@Getter
public enum AccountStatus {

    BLOCKED("BLOCKED"),
    CLOSED("CLOSED"),
    ACTIVE("ACTIVE");

    private final String value;

    AccountStatus(String value) {
        this.value = value;
    }
}
