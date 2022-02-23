package uz.doston.springcrm.controller;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.doston.springcrm.dto.organization.OrganizationCreateDto;
import uz.doston.springcrm.service.organization.OrganizationService;

@Controller
@RequestMapping(value = "/organization/*")
public class OrganizationController extends AbstractController<OrganizationService> {

    public OrganizationController(@Qualifier(value = "organizationService") OrganizationService service) {
        super(service);
    }

    @RequestMapping(value = "create/", method = RequestMethod.GET)
    public String createPage() {
        return "organization/create";
    }

    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public String create(@ModelAttribute OrganizationCreateDto dto) {
        service.create(dto);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.GET)
    public String deletePage(@PathVariable Long id) {
        return "organization/delete";
    }

    @RequestMapping(value = "delete/", method = RequestMethod.DELETE)
    public String delete() {
        return "redirect:/";
    }

    @RequestMapping(value = "update/{id}/", method = RequestMethod.GET)
    public String updatePage(@PathVariable Long id) {
        return "organization/update";
    }

    @RequestMapping(value = "update/", method = RequestMethod.PATCH)
    public String update() {
        return "redirect:/";
    }

    @RequestMapping("detail/{id}/")
    public String get(@PathVariable Long id) {
        return "organization/detail";
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
