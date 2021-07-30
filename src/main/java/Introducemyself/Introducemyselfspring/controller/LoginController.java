package Introducemyself.Introducemyselfspring.controller;

import Introducemyself.Introducemyselfspring.UserInfo;
import Introducemyself.Introducemyselfspring.controller.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    //사용자 정보를 가지고옵니다
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("join")
     public String Getjoin(Model model)
    {
        model.addAttribute("msg", "메시지");
        return "join";
    }

    @PostMapping("join")
    public String Postjoin(UserInfo userInfo) //값이 정상적으로 넘어옵니다
    {
        int i=0;
        return "redirect:/";

    }

    @PostMapping("login")
    public String Postlogin(Model model){
        model.addAttribute("","");
        return "main";
    }

}
