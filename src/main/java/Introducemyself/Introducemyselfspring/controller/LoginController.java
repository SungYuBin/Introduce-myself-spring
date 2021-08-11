package Introducemyself.Introducemyselfspring.controller;

import Introducemyself.Introducemyselfspring.UserInfo;
import Introducemyself.Introducemyselfspring.controller.Service.UserInfoService;
import Introducemyself.Introducemyselfspring.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    //사용자 정보를 가지고옵니다
    @Autowired
    UserInfoService userInfoService;

    @Autowired
    private AuthService authService;


    @GetMapping("join")
     public String Getjoin(Model model)
    {
        model.addAttribute("msg", "메시지");
        //return "login";
        return "join";
    }

    @PostMapping("join")
    public String Postjoin(UserInfo userInfo) //값이 정상적으로 넘어옵니다
    {
        int i=0;
        //return "";
        return "redirect:/";
    }


    @PostMapping("login")
    //@RequestMapping("login",method = RequestMethod.POST)
    //@RequestMapping(value ="login", method = RequestMethod.POST)
    public String Postlogin(String id, String pw , Model model)
    {
        UserInfo user =authService.loginUser(id,pw);
        if(user==null)
        {
            model.addAttribute("msg","로그인실패");
            model.addAttribute("url","/");
            return "redirect";
        }

        model.addAttribute("userid",user);
        return "main";
    }




}
