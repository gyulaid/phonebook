package hu.unideb.inf.phonebook.account;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public void addAccount(Account account) {
        account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));
        accountRepository.save(account);
    }

    public Account findAccountByUsername(String userName) {

        Optional<Account> account = accountRepository.findByUserName(userName);

        return account.orElse(null);
    }
}
