package ma.payflow.payment_engine.enums;

import lombok.Getter;

/**
 * @author Asmae
 **/
@Getter
public enum MovementDirection {
    DEBIT("DEBIT"),
    CREDIT("CREDIT");

    private final String value;

    MovementDirection(String value) {
        this.value = value;
    }
}
