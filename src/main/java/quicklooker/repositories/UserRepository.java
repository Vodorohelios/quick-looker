package quicklooker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import quicklooker.models.Post;
import quicklooker.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);

  List<User> findAll();

//  @Modifying
//  @Query("delete User u where username = :username")
//  void deleteByUsername(@Param("username") String username);
}
