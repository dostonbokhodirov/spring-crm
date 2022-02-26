package uz.doston.springcrm.service.task;

import org.springframework.stereotype.Service;
import uz.doston.springcrm.mapper.task.TaskMemberMapper;
import uz.doston.springcrm.repository.task.TaskMemberRepository;
import uz.doston.springcrm.service.base.AbstractService;

@Service
public class TaskMemberService extends AbstractService<TaskMemberMapper, TaskMemberRepository> {

    public TaskMemberService(TaskMemberMapper mapper, TaskMemberRepository repository) {
        super(mapper, repository);
    }



}
