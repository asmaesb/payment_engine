package ma.payflow.payment_engine.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
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

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

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
