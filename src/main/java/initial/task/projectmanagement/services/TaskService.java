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

    public void addTask(Task task){
        taskRepository.save(task);
    }

    public Task getTask(String taskId){
        return taskRepository.findById(taskId).get();
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(String projectId,String taskId) {
        Task currentTask = getTaskOfProject(projectId,taskId);
        if (currentTask !=null){
            taskRepository.deleteById(taskId);
        }

    }

    private Task getTaskOfProject(String projectId, String taskId) {
        List<Task> tasks = taskRepository.findByProjectId(projectId);
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }
}
