package uz.doston.springcrm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.doston.springcrm.dto.column.ProjectColumnCreateDto;
import uz.doston.springcrm.dto.column.ProjectColumnUpdateDto;
import uz.doston.springcrm.dto.project.ProjectCreateDto;
import uz.doston.springcrm.dto.project.ProjectUpdateDto;
import uz.doston.springcrm.dto.task.TaskDto;
import uz.doston.springcrm.service.project.ProjectColumnService;
import uz.doston.springcrm.service.project.ProjectService;
import uz.doston.springcrm.service.task.TaskService;

import java.util.List;

@Controller
@RequestMapping(value = "/project/*")
public class ProjectController extends AbstractController<ProjectService> {

    private ProjectColumnService columnService;

    private TaskService taskService;

    public ProjectController(ProjectService service,
                             ProjectColumnService columnService,
                             TaskService taskService) {
        super(service);
        this.columnService = columnService;
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

    @PostMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/project/list";
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
        model.addAttribute("participants", membersId);
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

    @GetMapping(value = "{id}/column/create")
    public String createColumnPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("column", new ProjectColumnCreateDto());
        return "project/column/create";
    }

    @PostMapping(value = "{id}/column/create")
    public String createColumn(@PathVariable("id") Long id, @ModelAttribute ProjectColumnCreateDto dto) {
        service.createColumn(id, dto);
        return "redirect:/project/detail";
    }

    @GetMapping(value = "{p_id}/column/delete/{c_id}")
    public String deleteColumnPage(Model model, @PathVariable("p_id") Long p_id, @PathVariable("c_id") Long c_id) {
        model.addAttribute("column", service.getColumn(c_id));
        return "project/column/delete";
    }

    @RequestMapping(value = "{p_id}/column/delete/{c_id}", method = RequestMethod.DELETE)
    public String deleteColumn(@PathVariable("p_id") Long p_id, @PathVariable("c_id") Long c_id) {
        service.deleteColumn(c_id);
        return "redirect:project/detail";
    }

    @GetMapping(value = "{p_id}/column/update/{c_id}")
    public String updateColumnPage(Model model, @PathVariable("p_id") Long p_id, @PathVariable("c_id") Long c_id) {
        model.addAttribute("column", service.getColumn(c_id));
        return "project/column/update";
    }

    @PostMapping(value = "{p_id}/column/update/{c_id}")
    public String updateColumn(@ModelAttribute ProjectColumnUpdateDto dto, @PathVariable("p_id") Long p_id, @PathVariable("c_id") Long c_id) {
        service.updateColumn(dto);
        return "redirect:project/list";
    }

}
