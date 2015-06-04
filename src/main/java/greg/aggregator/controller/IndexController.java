package greg.aggregator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by greg on 04.06.15.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(){
        return "/WEB-INF/jsp/index.jsp";
    }
}
