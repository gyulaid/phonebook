package hu.unideb.inf.phonebook.person.phone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    private String prefix;
    private String number;

    @Override
    public String toString() {
        return prefix+number;
    }
}
