package ma.payflow.payment_engine.enums;

import lombok.Getter;

/**
 * @author Asmae
 **/
@Getter
public enum IdentificationType {

    CIN("CIN"),
    PASSPORT("PASSPORT");

    private final String value;

    IdentificationType(String value){
        this.value = value;
    }
}
