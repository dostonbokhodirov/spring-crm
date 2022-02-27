package uz.doston.springcrm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.doston.springcrm.dto.task.TaskCreateDto;
import uz.doston.springcrm.dto.task.TaskUpdateDto;
import uz.doston.springcrm.service.task.TaskService;

@Controller
@RequestMapping(value = "/task/*")
public class TaskController extends AbstractController<TaskService> {

    public TaskController(TaskService service) {
        super(service);
    }

    @PostMapping(value = "create")
    public String createPage(Model model) {
        model.addAttribute("task", new TaskCreateDto());
        return "task/create";
    }

    @PostMapping(value = "")
    public String create(@ModelAttribute TaskCreateDto dto) {
        service.create(dto);
        return "redirect:/project/list";
    }

    @GetMapping(value = "{id}/update")
    public String updatePage(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("task", service.get(id));
        return "task/update";
    }

    @PostMapping(value = "{id}/update")
    public String update(@ModelAttribute TaskUpdateDto dto, @PathVariable(value = "id") Long id) {
        service.update(dto);
        return "redirect:/project/list";
    }

    @GetMapping(value = "{id}/delete")
    public String deletePage(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("task", service.get(id));
        return "task/delete";
    }

    @DeleteMapping(value = "{id}/delete")
    public String delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return "redirect:/project/list";
    }

    @GetMapping(value = "detail{id}")
    public String get(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("task", service.get(id));
        return "task/detail";
    }

    @GetMapping(value = "list")
    public String getAll(Model model) {
        model.addAttribute("tasks", service.getAll());
        return "task/list";
    }
}
