package hu.nero.worldweather.controllers;

import hu.nero.worldweather.service.UserService;
import hu.nero.worldweather.users.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

  private final UserService userService;

  @GetMapping(path = "users")
  public List<User> users() {
    return userService.getAllUsers();
  }
}
