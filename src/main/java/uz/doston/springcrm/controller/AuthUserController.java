package uz.doston.springcrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.doston.springcrm.service.auth.AuthUserService;

@Controller
@RequestMapping(value = "/auth/*")
public class AuthUserController extends AbstractController<AuthUserService> {

    public AuthUserController(AuthUserService service) {
        super(service);
    }

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
