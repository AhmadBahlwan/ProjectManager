package initial.task.projectmanagement.services;

import initial.task.projectmanagement.models.Task;
import initial.task.projectmanagement.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
    public List<Task> getAllTasks(String projectId){
        List<Task> tasks = new ArrayList<Task>();
        taskRepository.findByProjectId(projectId)
                .forEach(tasks::add);
        return tasks;
    }

}
