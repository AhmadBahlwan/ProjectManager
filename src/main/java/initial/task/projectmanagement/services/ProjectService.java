package initial.task.projectmanagement.services;

import initial.task.projectmanagement.models.Project;
import initial.task.projectmanagement.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProjectService {


    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectRepository archiveRepository;

    public List<Project> getAllProjects(){

        return (List<Project>) projectRepository.findAll();
    }

    public void createProject(Project project) {
        projectRepository.save(project);
    }

    public Optional<Project> getProject(String projectId){
        return projectRepository.findById(projectId);
    }

    public void modifyProject(String projectId,Project project) {
        projectRepository.save(project);
    }

    public void deleteProject(String projectId) {
        projectRepository.deleteById(projectId);
    }

    public void archiveProject(String projectId, Project project){
        archiveRepository.save(project);
    }


    public Project restoreProjectFromArchive(String projectId){
        Optional<Project> projects = archiveRepository.findById(projectId);
        return projects.get();
    }



}
