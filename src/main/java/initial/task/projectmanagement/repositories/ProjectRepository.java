package initial.task.projectmanagement.repositories;



import initial.task.projectmanagement.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,String> {

}
