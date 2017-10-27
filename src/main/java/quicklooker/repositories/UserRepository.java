package quicklooker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quicklooker.models.Post;
import quicklooker.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
  List<User> findAll();
}
