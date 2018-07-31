package components;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Task1 {

    private final ObjectProperty<Integer> mID = new SimpleObjectProperty<>(null);
    private final SimpleStringProperty mTitle = new SimpleStringProperty();
    private final SimpleStringProperty mDescription = new SimpleStringProperty();
    private Priority mPriority = Priority.LOW;
    private Status mStatus = Status.TODO;
    private Label mLabel = new Label(null);

    public Task1() {
    }

    public Task1(Integer id, String title, String description) {
        mID.set(id);
        mTitle.set(title);
        mDescription.set(description);
    }

    public Task1(Integer id, String title, String description, Priority priority, Status status, Label label) {
        mID.set(id);
        mTitle.set(title);
        mDescription.set(description);
        mPriority = priority;
        mStatus = status;
        mLabel = label;
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
        mLabel = label;
    }
}
