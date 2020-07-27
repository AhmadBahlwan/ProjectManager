package initial.task.projectmanagement.controllers;

import initial.task.projectmanagement.models.Task;
import initial.task.projectmanagement.services.ProjectService;
import initial.task.projectmanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/projects")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    ProjectService projectService;


    @GetMapping("/{projectId}/tasks")
    public List<Task> getAllTasks(@PathVariable String projectId){
        return taskService.getAllTasks(projectId);
    }

    @PostMapping("/{projectId}/tasks")
    public void addTask(@RequestBody Task task, @PathVariable String projectId){
        task.setProject(projectService.getProject(projectId).get());
        taskService.addTask(task);
    }

    @GetMapping("/tasks/{taskId}")
    public Task getTask(@PathVariable String taskId){
        return taskService.getTask(taskId);
    }

    @PutMapping("/{projectId}/tasks/{taskId}")
    public void updateTask(@RequestBody Task task,@PathVariable String projectId, @PathVariable String taskId){
        task.setProject(projectService.getProject(projectId).get());
        taskService.updateTask(task);
    }

    @DeleteMapping("/{projectId}/tasks/{taskId}")
    public void deleteTask(@PathVariable String projectId,@PathVariable String taskId){
        taskService.deleteTask(projectId,taskId);
    }


    @PutMapping("/{projectId}/tasks/{taskId}/complete")
    public void completeTask(@RequestBody Task task, @PathVariable String projectId, @PathVariable String taskId){
        taskService.completeTask(projectId,taskId);
    }


    @PutMapping("/{projectId}/tasks/{taskId}/undo")
    public void undDoTask(@RequestBody Task task, @PathVariable String projectId, @PathVariable String taskId){
        taskService.unDoTask(projectId,taskId);
    }


}
