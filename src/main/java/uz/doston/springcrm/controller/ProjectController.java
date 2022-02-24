//package uz.doston.springcrm.controller;
//
//
//import org.springframework.boot.Banner;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import uz.doston.springcrm.dto.project.ProjectCreateDto;
//import uz.doston.springcrm.dto.project.ProjectUpdateDto;
//import uz.doston.springcrm.service.project.ProjectService;
//
//@Controller
//@RequestMapping(value = "/project/*")
//public class ProjectController extends AbstractController<ProjectService> {
//
//    public ProjectController(ProjectService service) {
//        super(service);
//    }
//
//    @GetMapping(value = "create")
//    public String createPage(Model model) {
//        model.addAttribute("project", new ProjectCreateDto());
//        return "project/list";
//    }
//
//    @PostMapping(value = "")
//    public String create(@ModelAttribute ProjectCreateDto dto) {
//        service.create(dto);
//        return "redirect:organization/list";
//    }
//
//    @GetMapping(value = "delete/{id}")
//    public String deletePage(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("project", service.get(id));
//        return "project/delete";
//    }
//
//    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
//    public String delete() {
//        return "redirect:project/list";
//    }
//
//    @GetMapping(value = "update/{id}")
//    public String updatePage(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("project", service.get(id));
//        return "project/update";
//    }
//
//    @PostMapping(value = "update/{id}")
//    public String update(@ModelAttribute ProjectUpdateDto dto, @PathVariable("id") Long id) {
//        service.update(dto);
//        return "redirect:project/list";
//    }
//
//    @GetMapping(value = "detail{id}")
//    public String get(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("project", service.get(id));
//        return "project/detail";
//    }
//
//    @GetMapping(value = "list")
//    public String getAll(Model model) {
//        model.addAttribute("projects", service.getAll());
//        return "project/list";
//    }
//
//}
