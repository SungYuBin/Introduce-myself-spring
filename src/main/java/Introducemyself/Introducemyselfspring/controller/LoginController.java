package Introducemyself.Introducemyselfspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("join")
     public String login(Model model)
    {
        model.addAttribute("msg", "메시지");
        return "join";
    }

}
