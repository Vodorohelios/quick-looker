package quicklooker.repositories;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import quicklooker.config.DataTestConfig;
import quicklooker.models.Post;

import static org.junit.Assert.assertEquals;

@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataTestConfig.class})
@DatabaseSetup(PostRepositoryTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { PostRepositoryTest.DATASET })
@DirtiesContext
public class PostRepositoryTest {
  protected static final String DATASET = "classpath:datasets/users.xml";
  private static final String FIRST_ITEM = "Item 1";
  private static final String THIRD_ITEM = "Item 3";
  private static final String DESCRIPTION_FIELD = "description";

  @Autowired
  private PostRepository repository;

  @Test
  public void findCheckedShouldReturnTwoItems() {
    Post post = repository.findById(1);
    assertEquals((long) post.getId(), 1L);
  }
}
