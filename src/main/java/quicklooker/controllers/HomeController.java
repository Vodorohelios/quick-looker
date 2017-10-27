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
    model.addAttribute("users", userRepository.findAll());
    return "home";
  }
}
