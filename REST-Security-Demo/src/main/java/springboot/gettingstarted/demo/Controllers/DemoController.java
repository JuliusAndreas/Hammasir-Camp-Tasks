package springboot.gettingstarted.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {
    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/nothome")
    public String getNotHome(){
        return "Not home";
    }

    @GetMapping("/leaders")
    public String leaders(){
        return "leaders";
    }

    @GetMapping("/systems")
    public String systems(){
        return "systems";
    }
}
