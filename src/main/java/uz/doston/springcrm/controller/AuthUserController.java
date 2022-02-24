package uz.doston.springcrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.doston.springcrm.service.auth.AuthUserService;

@Controller
@RequestMapping(value = "/auth/*")
public class AuthUserController extends AbstractController<AuthUserService> {

    public AuthUserController(AuthUserService service) {
        super(service);
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "auth/login";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        return "auth/logout";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "auth/register";
    }

}
