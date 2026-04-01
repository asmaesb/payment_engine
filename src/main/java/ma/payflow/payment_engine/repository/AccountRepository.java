package ma.payflow.payment_engine.repository;

import ma.payflow.payment_engine.domain.Account;
import ma.payflow.payment_engine.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Asmae
 **/
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    @Query(value = "SELECT ACCOUNTNUMBER_SEQUENCE.NEXTVAL from DUAL" , nativeQuery = true)
    String generateAccountNumber();
}
