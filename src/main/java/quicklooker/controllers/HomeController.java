package quicklooker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quicklooker.services.UserService;

@Controller
@RequestMapping("/")
public class HomeController {

  @RequestMapping(method = RequestMethod.GET)
  public String home(Model model) {
    return "home";
  }

  @RequestMapping(value = "/testerror", method = RequestMethod.GET)
    public String testError() throws Exception {
    throw new Exception("Testing ErrorHandlerFilter!");
  }
}
