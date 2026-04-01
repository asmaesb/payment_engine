package ma.payflow.payment_engine.repository;

import ma.payflow.payment_engine.domain.Client;
import ma.payflow.payment_engine.enums.ClientStatus;

import ma.payflow.payment_engine.enums.IdentificationType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Asmae
 **/

@Repository
public interface ClientRepository extends JpaRepository<Client , String> {

    @Query(value = "SELECT CLIENTNUMBER_SEQUENCE.NEXTVAL from DUAL" , nativeQuery = true)
    Long generateClientNumber();

    Page<Client> findByClientStatus(ClientStatus status, Pageable pageable);

    Optional<Client> findByIdentificationTypeAndIdentificationNumber(IdentificationType identificationType, String identificationNumber);
}
