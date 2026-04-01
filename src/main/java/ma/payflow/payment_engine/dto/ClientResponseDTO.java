package ma.payflow.payment_engine.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Asmae
 **/

@Data
public class ClientResponseDTO {

    private String clientNumber;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String address;

    private String townCode;

    private String postalCode;

    private String branchCode;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

}
