package quicklooker.controllers;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import quicklooker.models.User;
import quicklooker.services.UserService;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UserControllerTest {

  @Test
  public void testShowRegistrationForm() throws Exception {
    UserService userServiceMock = mock(UserService.class);
    UserController controller = new UserController(userServiceMock);
    MockMvc mockMvc = standaloneSetup(controller).build();
    mockMvc.perform(get("/user/register"))
        .andExpect(view().name("registerForm"))
        .andExpect(model().attributeExists("user"));
  }

  @Test
  public void testProcessRegistration() throws Exception {
    UserService userServiceMock = mock(UserService.class);
    User unsaved = new User("username", "password", true, "Alexander", "Ivanov", "aivanov@mail.com");
    User saved = new User("username", "password", true, "Alexander", "Ivanov", "aivanov@mail.com");
    when(userServiceMock.save(unsaved)).thenReturn(saved);

    UserController controller = new UserController(userServiceMock);
    MockMvc mockMvc = standaloneSetup(controller).build();

    mockMvc.perform(post("/user/register")
        .param("username", "username")
        .param("password", "password")
        .param("firstname", "Alexander")
        .param("lastname", "Ivanov")
        .param("email", "aivanov@mail.com"));
//        .andExpect(redirectedUrl("/user/username"));

//    verify(userServiceMock, atLeastOnce()).save(unsaved);
  }

  @Test
  public void testFailValidationWithNoData() throws Exception {
    UserService userServiceMock = mock(UserService.class);
    UserController controller = new UserController(userServiceMock);
    MockMvc mockMvc = standaloneSetup(controller).build();

    mockMvc.perform(post("/user/register"))
            .andExpect(status().isOk())
            .andExpect(view().name("registerForm"))
            .andExpect(model().errorCount(4))
            .andExpect(model().attributeHasFieldErrors(
              "user", "password", "firstName", "lastName"
            ));
  }

  @Test
  public void testShowUserProfile() throws Exception {
    UserService userServiceMock = mock(UserService.class);
    String username = "username";
    User found = new User(username, "password", true, "Alexander", "Ivanov", "aivanov@mail.com");
    when(userServiceMock.findByUsername(username)).thenReturn(found);

    UserController controller = new UserController(userServiceMock);
    MockMvc mockMvc = standaloneSetup(controller).build();

    mockMvc.perform(get("/user/{username}", username))
        .andExpect(model().attributeExists("user"))
        .andExpect(model().attribute("user", found))
        .andExpect(view().name("profile"));
  }
}
