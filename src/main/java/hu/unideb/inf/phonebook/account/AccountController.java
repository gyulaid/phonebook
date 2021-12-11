package hu.unideb.inf.phonebook.account;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public String getAccountInfo(Model model) {
        Account account = accountService.findAccountByUsername(SecurityContextHolder.getContext()
                .getAuthentication().getName());
        model.addAttribute("accountInfo", account);

        return "accountPage";
    }

}
