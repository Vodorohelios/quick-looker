package quicklooker.services;

import org.springframework.stereotype.Service;
import quicklooker.models.User;

import java.util.List;

public interface UserService {
  User findByUsername(String username);
  List<User> findAll();
  User save(User user);
}
