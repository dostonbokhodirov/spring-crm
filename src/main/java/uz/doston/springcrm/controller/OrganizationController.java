package uz.doston.springcrm.controller;


import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import uz.doston.springcrm.dto.organization.OrganizationCreateDto;
import uz.doston.springcrm.dto.organization.OrganizationDto;
import uz.doston.springcrm.dto.organization.OrganizationUpdateDto;
import uz.doston.springcrm.repository.organization.OrganizationRepository;
import uz.doston.springcrm.service.organization.OrganizationLogoService;
import uz.doston.springcrm.service.organization.OrganizationService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(value = "/organization/*")
public class OrganizationController extends AbstractController<OrganizationService> {

    public OrganizationController(OrganizationService service) {
        super(service);
    }

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("organizations", service.getAll());
        return "organization/list";
    }

    @GetMapping("create")
    public String createPage(Model model) {

        model.addAttribute("dto", new OrganizationCreateDto());
        return "organization/create";
    }

    @SneakyThrows
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute(name = "dto") OrganizationCreateDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "organization/create";
        }
        service.create(dto);
        return "redirect:/organization/list";
    }

    @RequestMapping(value = "update/{code}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable String code) {

        model.addAttribute("organization", service.get(code));

        return "organization/update";
    }

    @SneakyThrows
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute OrganizationUpdateDto dto, BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return "organization/update";
        }
        dto.setId(id);
        service.update(dto);
        return "redirect:/organization/list";


    }

    @RequestMapping(value = "delete/{code}", method = RequestMethod.POST)
    public String delete(@PathVariable String code) {
        service.delete(code);
        return "redirect:/organization/list";
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    String detailsPage(Model model, @PathVariable Long id) {
        OrganizationDto organizationDto = service.get(id);
        model.addAttribute("organization", organizationDto);
        return "organization/detail";
    }
}
