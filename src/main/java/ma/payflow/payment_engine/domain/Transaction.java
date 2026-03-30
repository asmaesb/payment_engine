package ma.payflow.payment_engine.domain;

import jakarta.persistence.*;
import lombok.Data;
import ma.payflow.payment_engine.enums.TransactionStatus;
import ma.payflow.payment_engine.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Asmae
 **/
@Data
@Entity
@Table(name = "TRANSACTION")

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "debtorAccountNumber")
    private Account debtorAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creditorAccountNumber")
    private Account creditorAccount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(nullable = false)
    private BigDecimal transactionAmount;
    private String transferReason;

    private LocalDateTime transactionTime;

    @Column(unique = true, nullable = false)
    private String idempotencyKey;

    @PrePersist
    protected void onCreate() {
        this.transactionTime = LocalDateTime.now();
    }
}
