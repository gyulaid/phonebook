package hu.unideb.inf.phonebook;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Application {

    private final DatabaseInitializer databaseInitializer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
