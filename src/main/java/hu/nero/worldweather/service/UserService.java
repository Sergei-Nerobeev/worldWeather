package hu.nero.worldweather.service;

import hu.nero.worldweather.repo.UserRepository;
import hu.nero.worldweather.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User createUser(User user) {
    if (user.getId() != null) {
      throw new IllegalArgumentException("Id must be empty");
    }
    if (userRepository.findByEmail(user.getEmail()).isPresent()) {
      throw new IllegalArgumentException("Email already taken");
    }
    return userRepository.save(user);

  }

  public void deleteUser(Long id) {
    if (userRepository.findById(id).isEmpty()) {
      throw new IllegalArgumentException("User not found by id=%s".formatted(id));
    }
    userRepository.deleteById(id);
  }

  @Transactional
  public void updateUserEmail(Long id, String email) {
    var user = userRepository.findById(id)
                             .orElseThrow(() -> new IllegalArgumentException("User not found by id=%s".formatted(id)));
    if (email != null
        && !email.isEmpty()
        && !email.equals(user.getEmail())) {
      Optional<User> userOptional = userRepository.findByEmail(email);
      if (userOptional.isPresent()) {
        throw new IllegalArgumentException("Email already taken");
      }
      user.setEmail(email);
    }
  }
}
