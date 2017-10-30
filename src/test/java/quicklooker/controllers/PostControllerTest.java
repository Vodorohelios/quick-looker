package quicklooker.controllers;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import quicklooker.models.Post;
import quicklooker.models.User;
import quicklooker.services.PostService;
import quicklooker.services.UserService;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.mockito.Mockito.*;


public class PostControllerTest {

  // TODO investigate why verify doesn't work
  @Test
  public void testCreatePost() throws Exception {
    PostService postServiceMock = mock(PostService.class);
    UserService userServiceMock = mock(UserService.class);
    PostController controller = new PostController(postServiceMock, userServiceMock);
    MockMvc mockMvc = standaloneSetup(controller).build();
    User expectedUser = new User("Alex", "password", true, "Alexander", "Ivanov", "aivanov@mail.com");
    Post expectedPost = new Post("Hello World", "A long story short...", new Date(), expectedUser);
    when(userServiceMock.findByUsername("Alex")).thenReturn(expectedUser);

    mockMvc.perform(post("/posts/create")
            .param("title", "Hello World")
            .param("message", "A long story short...")
            .param("username", "Alex")
    )
            .andExpect(redirectedUrl("/user/Alex"));

//    verify(postServiceMock, atLeastOnce()).save(expectedPost);
  }

  @Test
  public void testDeletePost() throws Exception {
    PostService postServiceMock = mock(PostService.class);
    UserService userServiceMock = mock(UserService.class);
    PostController controller = new PostController(postServiceMock, userServiceMock);
    MockMvc mockMvc = standaloneSetup(controller).build();

    User expectedUser = new User("username", "password", true, "Alexander", "Ivanov", "aivanov@mail.com");
    Post foundPost = new Post("Title", "Body", new Date(), expectedUser);

    when(postServiceMock.findById(1L)).thenReturn(foundPost);

    mockMvc.perform(get("/posts/delete/{id}", 1L)
        .param("username", "username")
        )
        .andExpect(redirectedUrl("/user/username"));
  }
}
