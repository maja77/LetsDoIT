package components;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

public class Task {

    private static int lastID = 0;
    private final ObjectProperty<Integer> mID = new SimpleObjectProperty<>();
    private final SimpleStringProperty mTitle = new SimpleStringProperty();
    private final SimpleStringProperty mDescription = new SimpleStringProperty();
    private final SimpleObjectProperty<Priority> mPriority = new SimpleObjectProperty<>(Priority.MID);
    private final SimpleObjectProperty<Status> mStatus = new SimpleObjectProperty<>(Status.TODO);
    private Label mLabel = new Label(null);

    public static Task getObservableTask(){
        return new Task();
    }

    private Task(){}

    public Task(String title, String description) {
        mID.set(generateID());
        mTitle.set(title);
        mDescription.set(description);
    }

    public Task(String title, String description, Priority priority) {
        mID.set(generateID());
        mTitle.set(title);
        mDescription.set(description);
        mPriority.set(priority);
    }

    public Task(String title, String description, Priority priority, Status status) {
        mID.set(generateID());
        mTitle.set(title);
        mDescription.set(description);
        mPriority.set(priority);
        mStatus.set(status);
    }

    private static int generateID(){
        return ++lastID;
    }

    public Integer getID() {
        return mID.get();
    }

    public ObjectProperty<Integer> IDProperty() {
        return mID;
    }

    public void setID(Integer ID) {
        mID.set(ID);
    }

    public String getTitle() {
        return mTitle.get();
    }

    public SimpleStringProperty titleProperty() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle.set(title);
    }

    public String getDescription() {
        return mDescription.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription.set(description);
    }

//    public Priority getPriority() {
//        return mPriority;
//    }
//    public void setPriority(Priority priority) {
//        mPriority = priority;
//    }


    public Priority getPriority() {
        return mPriority.get();
    }

    public SimpleObjectProperty<Priority> priorityProperty() {
        return mPriority;
    }

    public void setPriority(Priority priority) {
        mPriority.set(priority);
    }

//    public Status getStatus() {
//        return mStatus;
//    }
//    public void setStatus(Status status) {
//        mStatus = status;
//    }


    public Status getStatus() {
        return mStatus.get();
    }

    public SimpleObjectProperty<Status> statusProperty() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus.set(status);
    }

    public Label getLabel() {
        return mLabel;
    }
    public void setLabel(Label label) {
        mLabel = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(mID, task.mID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mID);
    }
}
