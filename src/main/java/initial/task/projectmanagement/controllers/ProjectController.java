package initial.task.projectmanagement.controllers;
import initial.task.projectmanagement.models.Project;
import initial.task.projectmanagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/all")
    public List<Project>getAllProjects(){
        return projectService.getAllProjects();
    }

    @PostMapping("/create")
    public void createProject(@RequestBody Project project){
        projectService.createProject(project);
    }


}
