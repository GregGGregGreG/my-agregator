package greg.aggregator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by greg on 06.06.15.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}
