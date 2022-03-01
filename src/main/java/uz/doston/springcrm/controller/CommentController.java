package uz.doston.springcrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.doston.springcrm.service.comment.CommentService;

@Controller
@RequestMapping(value = "/comment/*")
public class CommentController extends AbstractController<CommentService> {

    public CommentController(CommentService service) {
        super(service);
    }
}
