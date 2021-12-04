package hu.unideb.inf.phonebook.person;

import hu.unideb.inf.phonebook.person.phone.Phone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;


    @GetMapping
    public String getPeople(Model model) {

        Person person = new Person();
        Phone phone = new Phone();

        person.setPhone(phone);
        model.addAttribute("person", person);

        List<Person> people = personService.getPeople();
        model.addAttribute("people", people);

        return "peoplePage";
    }

    @PostMapping
    public String addPerson(@ModelAttribute("person") Person person) {

        personService.savePerson(person);

        return "redirect:/people";
    }

    @GetMapping("/delete/{id}")
    public String removePerson(@PathVariable Long id) {

        personService.deletePerson(id);

        return "redirect:/people";
    }

}
