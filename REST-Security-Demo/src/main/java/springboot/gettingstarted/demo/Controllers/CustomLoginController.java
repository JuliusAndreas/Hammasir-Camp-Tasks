package springboot.gettingstarted.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomLoginController {
    @GetMapping("/showMyLoginPage")
    public String ShowMyLoginPage() {
        return "plain-login";
    }
}
