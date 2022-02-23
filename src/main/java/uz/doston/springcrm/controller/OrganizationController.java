package uz.doston.springcrm.controller;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.doston.springcrm.service.organization.OrganizationService;

@Controller
@RequestMapping(value = "/organization/*")
public class OrganizationController extends AbstractController<OrganizationService> {

    public OrganizationController(@Qualifier(value = "organizationService") OrganizationService service) {
        super(service);
    }

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("organizations", service.getAll());
        return "organization/list";
    }

//    public String update() {
//
//    }

}
