package quicklooker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quicklooker.models.Post;
import quicklooker.models.User;
import quicklooker.repositories.PostRepository;
import quicklooker.repositories.UserRepository;

import java.util.Date;

@Controller
@RequestMapping("/")
public class HomeController {

  private UserRepository userRepository;
  private PostRepository postRepository;

  @Autowired
  HomeController(UserRepository userRepository, PostRepository postRepository) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String home(Model model) {
    User user = new User("Chiki", "chiki", true, "Chikiti", "Chihihi",
            "chiki@mail.com");
    userRepository.save(user);

    Post post = new Post("New post!", "Hahahahhaha", new Date(), user);
    postRepository.save(post);

    model.addAttribute("users", userRepository.findAll());
    model.addAttribute("posts", postRepository.findAll());
    return "home";
  }
}
