package uz.doston.springcrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.doston.springcrm.dto.auth.AuthUserCreateDto;
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
    public String registerPage(Model model) {
        model.addAttribute("user", new AuthUserCreateDto());
        return "auth/register";
    }

    @PostMapping(value = "register")
    public String register(@ModelAttribute(value = "user") AuthUserCreateDto dto) {
        System.out.println(dto);
        service.create(dto);
        return "redirect:/auth/login";
    }

}
