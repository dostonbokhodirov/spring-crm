package uz.doston.springcrm.controller;


import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.doston.springcrm.dto.organization.OrganizationCreateDto;
import uz.doston.springcrm.dto.organization.OrganizationUpdateDto;
import uz.doston.springcrm.repository.organization.OrganizationRepository;
import uz.doston.springcrm.service.organization.OrganizationLogoService;
import uz.doston.springcrm.service.organization.OrganizationService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/organization/*")
public class OrganizationController extends AbstractController<OrganizationService> {

    public OrganizationController(OrganizationService service, OrganizationLogoService logoService, OrganizationRepository organizationRepository) {
        super(service);
    }

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("organizations", service.getAll());
//        return "organization/list";
        return "organization/list";
    }


//    public String deletePage(){
//
//    }
    @GetMapping("create")
    public String createPage(Model model) {

        model.addAttribute("dto", new OrganizationCreateDto());
        return "organization/create";
    }

    @SneakyThrows
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute(name = "dto") OrganizationCreateDto dto) {
        service.create(dto);
        return "redirect:/";
    }

    @GetMapping("update")
    public String updatePage(Model model) {
        model.addAttribute("dto", new OrganizationCreateDto());
        return "organization/create";
    }

    @SneakyThrows
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute(name = "dto") OrganizationUpdateDto dto) {
        service.update(dto);
        return "redirect:/";
    }
}
