package greg.aggregator.controller;

import greg.aggregator.jba.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by greg on 05.06.15.
 */
@Controller
public class IndexController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/index")
    public String index(Model model){
        model.addAttribute("items",itemService.getItems());
        return "index";
    }
}
