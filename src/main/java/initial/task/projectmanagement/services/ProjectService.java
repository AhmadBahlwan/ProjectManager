package initial.task.projectmanagement.services;

import initial.task.projectmanagement.models.Project;
import initial.task.projectmanagement.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProjectService {


    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAllProjects(){

        return (List<Project>) projectRepository.findAll();
    }

    public void createProject(Project project) {
        projectRepository.save(project);
    }



}
