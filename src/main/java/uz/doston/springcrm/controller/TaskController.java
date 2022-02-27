//package uz.doston.springcrm.controller;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import uz.doston.springcrm.dto.task.TaskCreateDto;
//import uz.doston.springcrm.service.task.TaskService;
//
//@Controller
//@RequestMapping(value = "/task/*")
//public class TaskController extends AbstractController<TaskService> {
//
//    public TaskController(TaskService service) {
//        super(service);
//    }
//
//    @PostMapping(value ="create")
//    public String createPage(Model model) {
//        model.addAttribute("task", new TaskCreateDto());
//        return "task/create";
//    }
//
//    @GetMapping(value="create")
//    public String createPage() {
//        return null;
//    }
//
//    @GetMapping(value="{id}/update")
//    public String updatePage(@PathVariable(value="id") Long id) {
//        return null;
//    }
//
//    @PostMapping(value="{id}/update")
//    public String update(@PathVariable(value="id") Long id) {
//        return null;
//    }
//
//    @GetMapping(value="{id}/delete")
//    public String deletePage(@PathVariable(value="id") Long id) {
//        return null;
//    }
//
//    @PostMapping(value="{id}/delete")
//    public String delete(@PathVariable(value="id") Long id) {
//        return null;
//    }
//
//    @GetMapping(value="detail{id}")
//    public String get(@PathVariable(value="id") Long id) {
//        return null;
//    }
//
//    @GetMapping(value="list")
//    public String getAll(@PathVariable(value="id") Long id) {
//        return null;
//    }
//}
