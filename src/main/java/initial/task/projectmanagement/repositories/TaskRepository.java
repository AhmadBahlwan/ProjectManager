package initial.task.projectmanagement.repositories;

import initial.task.projectmanagement.models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TaskRepository extends CrudRepository<Task,String> {


}
