package uz.doston.springcrm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.doston.springcrm.dto.project.ProjectCreateDto;
import uz.doston.springcrm.dto.project.ProjectUpdateDto;
import uz.doston.springcrm.dto.task.TaskDto;
import uz.doston.springcrm.service.project.ProjectService;
import uz.doston.springcrm.service.task.TaskService;

import java.util.List;

@Controller
@RequestMapping(value = "/project/*")
public class ProjectController extends AbstractController<ProjectService> {

    private final TaskService taskService;

    public ProjectController(ProjectService service, TaskService taskService) {
        super(service);
        this.taskService = taskService;
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
        List<TaskDto> allTasks = taskService.getAllTasks(id);
        Long membersId = service.getMembersId(id);

        int frozenTasks = 0;
        for (TaskDto task : allTasks) {
            if (task.isFrozen()) frozenTasks++;
        }

        int doneTasks = 0;
        for (TaskDto allTask : allTasks) {
            if (allTask.isCompleted()) doneTasks++;
        }

        model.addAttribute("project", service.get(id));
        model.addAttribute("frozenTasks", frozenTasks);
        model.addAttribute("participants",membersId);
        model.addAttribute("tasksCount", taskService.getAllTasks(id).size());
        model.addAttribute("doneTasks", doneTasks);
        model.addAttribute("columns", service.getAllColumnEntity(id));
        return "project/detail";
    }

    @GetMapping(value = "list")
    public String getAll(Model model) {
        model.addAttribute("projects", service.getAll());
        return "project/list";
    }

}
