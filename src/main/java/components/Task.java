package components;

public class Task {

    private String title;
    private String description;
    private Long i;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
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

    public Long getI() {
        return i;
    }

    public void setI(Long i) {
        this.i = i;
    }
}
