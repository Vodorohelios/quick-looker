package quicklooker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import quicklooker.forms.PostForm;
import quicklooker.models.Post;
import quicklooker.models.User;
import quicklooker.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

  @RequestMapping(value="/users", method=GET)
  public String showUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
  }

  @RequestMapping(value="/register", method=GET)
  public String showRegistrationForm(Model model) {
    model.addAttribute("user", new User());
    return "registerForm";
  }

  @RequestMapping(value="/register", method=POST)
  public String processRegistration(
          @RequestParam("passwordCheck") String passwordCheck, @Valid User user,
          BindingResult bindingResult, Errors errors, Model model) {
    if (!user.getPassword().equals(passwordCheck)) {
      bindingResult.rejectValue("password", "message.passwordDoesNotMatch", "The password does not match.");
      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Found user!");
      return "registerForm";
    }
    if (errors.hasErrors()) {
      return "registerForm";
    }
    if (userService.findByUsername(user.getUsername()) != null) {
      bindingResult.rejectValue("username", "message.userAlreadyExists", "This username already exists.");
      return "registerForm";
    }

    // initialize user's posts
    user.setPosts(new HashSet<Post>());
    // activate user profile
    user.setEnabled(true);
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

  @RequestMapping(value="/delete/{username}", method=POST)
  public String deleteUser(@PathVariable String username,
                           HttpServletRequest request, HttpServletResponse response) {
    userService.deleteByUsername(username);
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "redirect:/login?logout";
  }

}

