package quicklooker.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import quicklooker.config.DataTestConfig;
import quicklooker.models.Post;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataTestConfig.class})
public class PostRepositoryTest2 {

  private PostRepository postRepository;

  @Autowired
  public PostRepositoryTest2(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Test
  public void findCheckedShouldReturnTwoItems() {
    Post post = postRepository.findById(1);
    assertNotNull(post);
    assertEquals((long) post.getId(), 1L);
  }
}
