package uz.doston.springcrm.controller;

import org.springframework.stereotype.Controller;
import uz.doston.springcrm.service.auth.AuthUserService;

@Controller
public class AuthUserController extends AbstractController<AuthUserService> {

    public AuthUserController(AuthUserService service) {
        super(service);
    }

}
