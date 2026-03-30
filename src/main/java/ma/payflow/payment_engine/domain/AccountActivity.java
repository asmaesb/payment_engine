package ma.payflow.payment_engine.domain;

import jakarta.persistence.*;
import lombok.Data;
import ma.payflow.payment_engine.enums.MovementDirection;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Asmae
 **/
@Data
@Entity
@Table(name = "ACCOUNT_ACTIVITY")
public class AccountActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountNumber")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transactionId")
    private Transaction transaction;

    @Enumerated(EnumType.STRING)
    private MovementDirection direction; // new enum: DEBIT / CREDIT

    private BigDecimal amount;

    private BigDecimal balanceAfter;

    private LocalDateTime createdAt;
}
