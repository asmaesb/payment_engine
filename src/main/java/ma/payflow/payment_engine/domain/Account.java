package ma.payflow.payment_engine.domain;

import jakarta.persistence.*;
import lombok.Data;
import ma.payflow.payment_engine.enums.AccountStatus;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Asmae
 **/

@Data
@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    private String accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientNumber" )
    private Client client;


    @OneToMany(mappedBy = "account")
    private List<AccountActivity> accountActivities;


    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Column(nullable = false)
    private BigDecimal balance;

    @Version
    private Long version;
}
