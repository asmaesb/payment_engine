package ma.payflow.payment_engine.repository;

import ma.payflow.payment_engine.domain.Transaction;
import ma.payflow.payment_engine.enums.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Asmae
 **/
@Repository
public interface TransactionRepository extends JpaRepository<Transaction , String> {
    List<Transaction> findByStatus(TransactionStatus status);
    Optional<Transaction> findByIdempotencyKey(String idempotencyKey);
}
