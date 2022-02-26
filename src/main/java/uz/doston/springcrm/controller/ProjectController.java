package uz.doston.springcrm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.doston.springcrm.dto.auth.AuthUserDto;
import uz.doston.springcrm.dto.column.ProjectColumnDto;
import uz.doston.springcrm.dto.project.ProjectCreateDto;
import uz.doston.springcrm.dto.project.ProjectUpdateDto;
import uz.doston.springcrm.dto.task.TaskDto;
import uz.doston.springcrm.entity.task.Task;
import uz.doston.springcrm.repository.task.TaskRepository;
import uz.doston.springcrm.service.auth.AuthUserService;
import uz.doston.springcrm.service.project.ProjectColumnService;
import uz.doston.springcrm.service.project.ProjectService;
import uz.doston.springcrm.service.task.TaskService;

import java.util.List;

@Controller
@RequestMapping(value = "/project/*")
public class ProjectController extends AbstractController<ProjectService> {

    private AuthUserService userService;
    private TaskService taskService;
    private ProjectColumnService columnService;

    public ProjectController(ProjectService service,
                             AuthUserService userService,
                             TaskService taskService,
                             ProjectColumnService columnService) {
        super(service);
        this.userService = userService;
        this.taskService = taskService;
        this.columnService = columnService;
    }

    @GetMapping(value = "create")
    public String createPage(Model model) {
        model.addAttribute("project", new ProjectCreateDto());
        return "project/create";
    }

    @PostMapping(value = "")
    public String create(@ModelAttribute ProjectCreateDto dto) {
        service.create(dto);
        return "redirect:/project/list";
    }

    @GetMapping(value = "delete/{id}")
    public String deletePage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("project", service.get(id));
        return "project/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String delete() {
        return "redirect:project/list";
    }

    @GetMapping(value = "update/{id}")
    public String updatePage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("project", service.get(id));
        return "project/update";
    }

    @PostMapping(value = "update/{id}")
    public String update(@ModelAttribute ProjectUpdateDto dto, @PathVariable("id") Long id) {
        service.update(dto);
        return "redirect:project/list";
    }

    @PostMapping(value = "detail/{id}")
    public String get(Model model, @PathVariable("id") Long id) {
        model.addAttribute("project", service.get(id));
        return "project/detail";
    }

    @GetMapping(value = "list")
    public String getAll(Model model) {
        model.addAttribute("projects", service.getAll());
        return "project/list";
    }

    @RequestMapping(value = "{id}/column/list")
    public String getAllColumns(@PathVariable("id") Long id, Model model) {
        List<ProjectColumnDto> allColumns = columnService.getAllColumns(id);
//        List<TaskDto> allTasks = taskService.getAllTasks(id);
//        List<Long> membersId = service.getMembersId(id);
//        List<AuthUserDto> allUsers = userService.getAllUsers(membersId);

        model.addAttribute("project", service.get(id));
        model.addAttribute("columns", service.getAllColumns(id));

        return "task/detail";
    }

//
//    @GetMapping(value = "{id}/task/list")
//    public String getTasksList(@PathVariable("id") Long id,Model model) {
//        model.addAttribute("tasks",service.getAllTasks(id));
//
//        return "task/index2";
//    }
}
