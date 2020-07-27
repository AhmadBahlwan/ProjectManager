package initial.task.projectmanagement.controllers;

import initial.task.projectmanagement.models.Task;
import initial.task.projectmanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/projects")
public class TaskController {

    @Autowired
    TaskService taskService;


    @GetMapping("/{projectId}/tasks")
    public List<Task> getAllTasks(@PathVariable String projectId){
        return taskService.getAllTasks(projectId);
    }


}
