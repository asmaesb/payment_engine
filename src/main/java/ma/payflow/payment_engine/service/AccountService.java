package ma.payflow.payment_engine.service;

import lombok.RequiredArgsConstructor;
import ma.payflow.payment_engine.domain.Account;
import ma.payflow.payment_engine.dto.AccountRequestDTO;
import ma.payflow.payment_engine.dto.AccountResponseDTO;
import ma.payflow.payment_engine.repository.AccountRepository;
import org.springframework.stereotype.Service;

/**
 * @author Asmae
 **/
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO){

        Account account = new Account();

        return  new AccountResponseDTO();
    }

}
