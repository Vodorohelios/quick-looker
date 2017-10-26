package quicklooker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quicklooker.models.Post;
import quicklooker.repositories.PostRepository;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

  private PostRepository postRepository;

  @Autowired
  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }
  @Override
  public Post findById(long id) {
    return postRepository.findById(id);
  }

  @Override
  public List<Post> findAll() {
    return postRepository.findAll();
  }
}
