package quicklooker.controllers;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import quicklooker.repositories.UserRepository;

public class HomeControllerTest {

  @Test
  public void testHomePage() throws Exception {
    UserRepository mockRepository = mock(UserRepository.class);
    HomeController controller = new HomeController(mockRepository);
    MockMvc mockMvc = standaloneSetup(controller).build();
    mockMvc.perform(get("/"))
           .andExpect(view().name("home"));
  }

}
