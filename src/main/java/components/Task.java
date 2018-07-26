package components;

public class Task {

    private String mTitle;
    private String mDescription;
    private Priority mPriority = Priority.LOW;
    private Status mStatus = Status.TODO;
    private Label mLabel;

    public Task(String title, Priority priority, Status status) {
        mTitle = title;
        mPriority = priority;
        mStatus = status;
    }

    public Task(String title, String description, Priority priority, Status status) {
        mTitle = title;
        mDescription = description;
        mPriority = priority;
        mStatus = status;
    }

    public Task(String title, String description, Priority priority, Status status, Label label) {
        mTitle = title;
        mDescription = description;
        mPriority = priority;
        mStatus = status;
        mLabel = label;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Priority getPriority() {
        return mPriority;
    }

    public void setPriority(Priority priority) {
        mPriority = priority;
    }

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

    public Label getLabel() {
        return mLabel;
    }

    public void setLabel(Label label) {
        this.mLabel = label;
    }
}
