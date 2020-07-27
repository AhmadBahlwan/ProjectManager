package initial.task.projectmanagement.controllers;
import initial.task.projectmanagement.models.Project;
import initial.task.projectmanagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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

    @GetMapping("/{projectId}")
    public Optional<Project> getProject(@PathVariable String projectId){
        return projectService.getProject(projectId);
    }

    @PutMapping("/{projectId}")
    public void modifyProject(@RequestBody Project project, @PathVariable String projectId){
        projectService.modifyProject(projectId,project);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable String projectId){
        projectService.deleteProject(projectId);
    }

    @PostMapping("/archive/{projectId}")
    public void archiveProject(@RequestBody Project project, @PathVariable String projectId){
        projectService.archiveProject(projectId,project);
    }

    @GetMapping("/archive/{projectId}")
    public Project restoreProjectFromArchive(@PathVariable String projectId){
        return projectService.restoreProjectFromArchive(projectId);
    }

}
