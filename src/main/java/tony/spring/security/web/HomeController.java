package tony.spring.security.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Tony on 16/7/5.
 */

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @RequestMapping(value = {"/welcome", "/home"}, method = RequestMethod.GET)
    public String home(ModelMap model) {
        model.addAttribute("msg", "Welcome!");
        return "msg";
    }

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String admin(ModelMap model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        model.addAttribute("msg", "Welcome! " + name);
        return "msg";
    }
}
