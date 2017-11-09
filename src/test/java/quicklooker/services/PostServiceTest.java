package quicklooker.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import quicklooker.models.Post;
import quicklooker.repositories.PostRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

  private PostRepository mockPostRepository;
  private PostService postService;

  @Before
  public void setup() {
    mockPostRepository = mock(PostRepository.class);
    postService = new PostServiceImpl(mockPostRepository);
  }

  @Test
  public void testFindById() {
    Post expectedPost = new Post();
    expectedPost.setId(1L);
    when(mockPostRepository.findById(1L)).thenReturn(expectedPost);

    Post post = postService.findById(1L);
    assertEquals(1L, (long) expectedPost.getId());
    verify(mockPostRepository).findById(1L);
  }

  @Test
  public void testFindAll() {
    List<Post> expectedPostList = new ArrayList<>();
    for (int i = 0; i < 3; ++i) {
      expectedPostList.add(new Post());
      expectedPostList.get(i).setId((long) (i + 1));
    }

    when(mockPostRepository.findAll()).thenReturn(expectedPostList);

    List<Post> postList = postService.findAll();

    assertEquals(1L, (long) postList.get(0).getId());
    assertEquals(2L, (long) postList.get(1).getId());
    assertEquals(3L, (long) postList.get(2).getId());

    verify(mockPostRepository).findAll();
  }

  @Test
  public void testSave() {
    Post expectedPost = new Post("Title", "Body", null, null);

    when(mockPostRepository.save(any(Post.class))).thenReturn(expectedPost);

    Post post = postService.save(new Post());

    assertEquals(expectedPost.getTitle(), post.getTitle());
    assertEquals(expectedPost.getBody(), post.getBody());

    verify(mockPostRepository).save(any(Post.class));
  }

  @Test
  public void testDelete() {
    postService.delete(new Post());

    verify(mockPostRepository).delete(any(Post.class));
  }

}
