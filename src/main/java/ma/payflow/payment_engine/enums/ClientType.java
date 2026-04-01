package ma.payflow.payment_engine.enums;

import lombok.Getter;

/**
 * @author Asmae
 **/
@Getter
public enum ClientType {
    BANK_PERSONNEL("001"),
    INDIVIDUAL("004");

    private final String value;

    ClientType(String value){
        this.value = value;
    }
}
