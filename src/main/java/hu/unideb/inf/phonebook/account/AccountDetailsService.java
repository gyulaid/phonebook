package hu.unideb.inf.phonebook.account;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<Account> account = accountRepository.findByUserName(userName);

        if (account.isEmpty()) {
            throw new UsernameNotFoundException("No user found with such user name");
        }

        User.UserBuilder builder = User.withUsername(userName)
                .password(new BCryptPasswordEncoder().encode(account.get().getPassword()));

        if (account.get().getRole().equals(Role.ADMIN)) {
            builder.roles("USER, ADMIN");
        } else if (account.get().getRole().equals(Role.USER)) {
            builder.roles("USER");
        }

        return builder.build();
    }


}


