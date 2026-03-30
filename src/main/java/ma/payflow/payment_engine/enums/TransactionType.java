package ma.payflow.payment_engine.enums;

import lombok.Getter;

/**
 * @author Asmae
 **/

@Getter
public enum TransactionType {
    TRANSFER ("TRANSFER"),
    INSTANT_TRANSFER ("INSTANT_TRANSFER");

    private final String value;

     TransactionType(String value){
        this.value = value;
    }



}
