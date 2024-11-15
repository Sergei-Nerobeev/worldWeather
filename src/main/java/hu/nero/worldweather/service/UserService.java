package hu.nero.worldweather.service;

import hu.nero.worldweather.repo.UserRepository;
import hu.nero.worldweather.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
//    return List.of(
//        new User(
//            1L,
//            "Joe",
//            "joeb@mail.com",
//            LocalDate.of(1940, 12, 3)
//        ),
//        new User(
//            2L,
//            "Donald",
//            "donaldt@gmail.com",
//            LocalDate.of(1945, 8, 12)
//        ),
//        new User(
//            3L,
//            "Barak",
//            "barakko@yahoo.com",
//            LocalDate.of(1955, 3, 23)
//        )
//    );
        return userRepository.findAll();
  }
}
