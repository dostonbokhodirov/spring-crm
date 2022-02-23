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

    @GetMapping(value = "create")
    public String createPage() {
        return "organization/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute OrganizationCreateDto dto) {
        service.create(dto);
        return "redirect:/";
    }

    @GetMapping(value = "delete/{id}")
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String delete() {
        return "redirect:/";
    }

    @GetMapping(value = "update/{id}")
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/update";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PATCH)
    public String update(@PathVariable String id) {
        return "redirect:/";
    }

    @GetMapping("detail/{id}")
    public String get(Model model, @PathVariable(name = "id") Long id) {
        return "organization/detail";
    }


    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("organizations", service.getAll());
        return "organization/list";
    }

}
