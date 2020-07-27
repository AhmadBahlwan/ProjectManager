package initial.task.projectmanagement.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    private String id;
    private String title;
    private String description;

    public Project() {
    }


    public Project(String id, String title, String description, List<Task>tasks) {
        this.id = id;
        this.title = title;
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
