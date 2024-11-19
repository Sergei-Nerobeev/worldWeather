package hu.nero.worldweather.controllers;

import hu.nero.worldweather.service.UserService;
import hu.nero.worldweather.users.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

  private final UserService userService;

  @GetMapping(path = "users")
  public List<User> users() {
    return userService.getAllUsers();
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }
  @DeleteMapping("/{userId}")
  public void deleteUser(@PathVariable("userId") Long id) {
    userService.deleteUser(id);
  }
}
