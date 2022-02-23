package uz.doston.springcrm.controller.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping(value = "/auth/*")
public class AuthController {

    @GetMapping
    @RequestMapping(value = "login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping
    @RequestMapping(value = "logout")
    public String logout(){
        return "auth/logout";
    }

}
