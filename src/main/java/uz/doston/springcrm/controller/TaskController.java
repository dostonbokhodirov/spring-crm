package uz.doston.springcrm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.doston.springcrm.dto.column.ProjectColumnDto;
import uz.doston.springcrm.dto.task.TaskCreateDto;
import uz.doston.springcrm.dto.task.TaskUpdateDto;
import uz.doston.springcrm.service.comment.CommentService;
import uz.doston.springcrm.service.project.ProjectColumnService;
import uz.doston.springcrm.service.task.TaskService;

@Controller
@RequestMapping(value = "/task/*")
public class TaskController extends AbstractController<TaskService> {

    private final ProjectColumnService columnService;
    private final CommentService commentService;


    public TaskController(TaskService service, ProjectColumnService columnService, CommentService commentService) {
        super(service);
        this.columnService = columnService;
        this.commentService = commentService;
    }


    @GetMapping(value = "create/{id}")
    public String createPage(Model model, @PathVariable(value = "id") Long columnId) {
        model.addAttribute("task", new TaskCreateDto(columnId));
        return "task/create";
    }

    @PostMapping(value = "create")
    public String create(@ModelAttribute TaskCreateDto dto) {
        ProjectColumnDto columnDto = columnService.get(dto.getColumnId());
        dto.setProjectId(columnDto.getProjectId());
        dto.setOwnerId(1L);
        service.create(dto);
        return "redirect:/project/list";
    }

    @GetMapping(value = "update/{id}")
    public String updatePage(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("task", service.get(id));
        return "task/update";
    }

    @PostMapping(value = "update/{id}")
    public String update(@ModelAttribute TaskUpdateDto dto, @PathVariable(value = "id") Long id) {
        service.update(dto);
        return "redirect:/project/list";
    }

    @GetMapping(value = "delete/{id}")
    public String deletePage(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("task", service.get(id));
        return "task/delete";
    }

    @DeleteMapping(value = "delete/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return "redirect:/project/list";
    }

    @GetMapping(value = "detail/{id}")
    public String get(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("task", service.get(id));
        model.addAttribute("comments", commentService.getAllByTaskId(id));
        return "task/detail";
    }

    @GetMapping(value = "list")
    public String getAll(Model model) {
        model.addAttribute("tasks", service.getAll());
        return "task/list";
    }
}
