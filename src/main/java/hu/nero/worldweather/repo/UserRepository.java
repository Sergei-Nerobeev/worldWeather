package hu.nero.worldweather.repo;

import hu.nero.worldweather.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
