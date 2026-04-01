package ma.payflow.payment_engine.repository;

import ma.payflow.payment_engine.domain.AccountActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Asmae
 **/
@Repository
public interface AccountActivityRepository extends JpaRepository<AccountActivity , String> {
}
