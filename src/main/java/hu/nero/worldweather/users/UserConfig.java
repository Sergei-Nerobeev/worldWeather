package hu.nero.worldweather.users;

import hu.nero.worldweather.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository userRepository
    ) {
        return (args) -> {
            var userList = List.of(
                    new User(
                            null,
                            "Joe",
                            "joeb@mail.com",
                            LocalDate.of(1940, 12, 3)
                    ),
                    new User(
                            null,
                            "Donald",
                            "donaldt@gmail.com",
                            LocalDate.of(1945, 8, 12)
                    ),
                    new User(
                            null,
                            "Barak",
                            "barakko@yahoo.com",
                            LocalDate.of(1955, 3, 23)
                    ));
            userRepository.saveAll(userList);
        };
    }
}
