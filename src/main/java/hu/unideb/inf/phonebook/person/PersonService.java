package hu.unideb.inf.phonebook.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    public Person getPerson(Long id) {
        return personRepository.getById(id);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }


}
