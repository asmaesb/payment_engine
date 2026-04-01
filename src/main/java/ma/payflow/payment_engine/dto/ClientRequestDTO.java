package ma.payflow.payment_engine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.payflow.payment_engine.enums.ClientType;
import ma.payflow.payment_engine.enums.IdentificationType;

/**
 * @author Asmae
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDTO {

    private String firstName;

    private String lastName;

    private String identificationNumber;

    private IdentificationType identificationType;

    private ClientType clientType;

    private String phoneNumber;

    private String email;

    private String address;

    private String townCode;

    private String postalCode;


}
