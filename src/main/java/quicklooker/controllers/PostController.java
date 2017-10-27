package quicklooker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quicklooker.forms.PostForm;
import quicklooker.models.Post;
import quicklooker.models.User;
import quicklooker.repositories.PostRepository;
import quicklooker.repositories.UserRepository;

import java.util.Date;

@Controller
@RequestMapping("/posts")
public class PostController {

  private PostRepository postRepository;
  private UserRepository userRepository;

  @Autowired
  PostController(PostRepository postRepository, UserRepository userRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }

  @RequestMapping(value="/create", method = RequestMethod.POST)
  public String createPost(
          PostForm form,
          Model model) {
    postRepository.save(new Post(form.getTitle(), form.getMessage(), new Date(),
            userRepository.findByUsername(form.getUsername())));

    model.addAttribute("username", form.getUsername());
    return "redirect:/user/{username}";
  }

  @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
  public String deletePost(
          @PathVariable("id") Long id,
          @RequestParam(value="username") String username,
          Model model) {
    postRepository.delete(postRepository.findById(id));

    model.addAttribute("username", username);
    return "redirect:/user/{username}";
  }

}
