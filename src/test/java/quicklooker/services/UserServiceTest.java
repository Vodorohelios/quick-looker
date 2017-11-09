package quicklooker.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import quicklooker.models.User;
import quicklooker.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

  private UserRepository mockUserRepository;
  private UserService userService;

  @Before
  public void setup() {
    mockUserRepository = mock(UserRepository.class);
    userService = new UserServiceImpl(mockUserRepository);
  }

  @Test
  public void testFindByUsername() {
    String username = "username";
    User expectedUser = new User();
    expectedUser.setUsername(username);
    when(mockUserRepository.findByUsername(username)).thenReturn(expectedUser);

    User user = userService.findByUsername(username);

    assertEquals(user.getUsername(), expectedUser.getUsername());

    verify(mockUserRepository).findByUsername(username);
  }

  @Test
  public void testFindAll() {
    List<User> expectedUserList = new ArrayList<>();

    for (int i = 0; i < 3; ++i) {
      expectedUserList.add(new User());
      expectedUserList.get(i).setUsername("user-" + (i + 1));
    }

    when(mockUserRepository.findAll()).thenReturn(expectedUserList);

    List<User> userList = userService.findAll();

    assertEquals("user-1", userList.get(0).getUsername());
    assertEquals("user-2", userList.get(1).getUsername());
    assertEquals("user-3", userList.get(2).getUsername());

    verify(mockUserRepository, times(1)).findAll();
  }

  @Test
  public void testSave() {
    User expectedUser = new User();
    expectedUser.setUsername("user-1");

    when(mockUserRepository.save(any(User.class))).thenReturn(expectedUser);

    User user = userService.save(new User());

    assertEquals("user-1", user.getUsername());

    verify(mockUserRepository).save(any(User.class));
  }

  @Test
  public void testDeleteByUsername() {
    String username = "user-1";
    userService.deleteByUsername(username);

    verify(mockUserRepository).delete(any(User.class));
  }
}
