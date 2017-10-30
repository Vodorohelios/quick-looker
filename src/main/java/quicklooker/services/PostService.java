package quicklooker.services;

import org.springframework.stereotype.Service;
import quicklooker.models.Post;

import java.util.List;

public interface PostService {
  Post findById(long id);
  List<Post>  findAll();
  Post save(Post post);
  void delete(Post post);
}
