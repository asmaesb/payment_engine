package ma.payflow.payment_engine.domain;

import jakarta.persistence.*;
import lombok.Data;
import ma.payflow.payment_engine.enums.ClientStatus;
import ma.payflow.payment_engine.enums.ClientType;
import ma.payflow.payment_engine.enums.IdentificationType;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Asmae
 **/
@Data
@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    private String clientNumber;

    private String firstName;

    private String lastName;

    private String identificationNumber;

    @Enumerated(EnumType.STRING)
    private IdentificationType identificationType;

    private String phoneNumber;

    private String email;

    private String address;

    private String townCode;

    private String postalCode;

    private String branchCode;

    @Enumerated(EnumType.STRING)
    private ClientType clientType;

    @Enumerated(EnumType.STRING)
    private ClientStatus clientStatus;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.modifiedAt = LocalDateTime.now();
    }





}
