package hu.unideb.inf.phonebook;

import hu.unideb.inf.phonebook.account.Account;
import hu.unideb.inf.phonebook.account.AccountService;
import hu.unideb.inf.phonebook.account.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {

    private final AccountService accountService;

    private Account adminAccount = Account.builder()
            .userName("admin")
            .password("admin")
            .role(Role.ADMIN)
            .build();

    private Account userAccount = Account.builder()
            .userName("user")
            .password("user")
            .role(Role.USER)
            .build();

    @PostConstruct
    private void initialize() {
        accountService.addAccount(adminAccount);
        accountService.addAccount(userAccount);
    }

}
