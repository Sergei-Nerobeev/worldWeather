package hu.nero.worldweather.users;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class User {
  private Long id;
  private String userName;
  private String email;
  private LocalDate birthDate;
}
