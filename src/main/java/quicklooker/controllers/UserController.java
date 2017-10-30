package quicklooker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import quicklooker.forms.PostForm;
import quicklooker.models.Post;
import quicklooker.models.User;
import quicklooker.repositories.UserRepository;
import quicklooker.services.UserService;

import javax.validation.Valid;

import java.util.HashSet;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/user")
public class UserController {
  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value="/register", method=GET)
  public String showRegistrationForm(Model model) {
    model.addAttribute("user", new User());
    return "registerForm";
  }

  @RequestMapping(value="/register", method=POST)
  public String processRegistration(
          @Valid User user, Errors errors, Model model) {
    if (errors.hasErrors()) {
      return "registerForm";
    }

    user.setPosts(new HashSet<Post>());
    userService.save(user);
    model.addAttribute("username", user.getUsername());
    return "redirect:/user/{username}";
  }

  @RequestMapping(value="/{username}", method=GET)
  public String showUserProfile(@PathVariable String username, Model model) {
    User user = userService.findByUsername(username);
    model.addAttribute("user", user);
    model.addAttribute("postForm", new PostForm());
    return "profile";
  }

}

