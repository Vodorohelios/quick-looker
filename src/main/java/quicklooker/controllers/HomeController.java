package quicklooker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quicklooker.repositories.UserRepository;
import quicklooker.services.UserService;

@Controller
@RequestMapping("/")
public class HomeController {

  private UserService userService;

  @Autowired
  HomeController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String home(Model model) {
    model.addAttribute("users", userService.findAll());
    return "home";
  }
}
