package hu.unideb.inf.phonebook.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;


    @GetMapping
    public String getPeople(Model model) {

        List<Person> people = personService.getPeople();
        model.addAttribute("people", people);

        return "";
    }
}
