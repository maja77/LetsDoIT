package letsDoIT;

import components.Priority;
import components.Status;
import components.Task;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;


public class Controller implements Initializable {

    private final Task currentTask = new Task();

    private final ObservableList<Task> tasks = FXCollections.observableArrayList();
    private final ObservableList<Priority> priorities = FXCollections.observableArrayList(Priority.LOW, Priority.MID, Priority.HIGH);


    @FXML
    private TableView<Task> taskTable = new TableView<>();

    @FXML
    private TableColumn<Task, Priority> priorityColumn;

    @FXML
    private TableColumn<Task, Status> statusColumn;

    @FXML
    private TableColumn<Task, String> titleColumn;

    @FXML
    private TableColumn<Task, String> descriptionColumn;

    @FXML
    private TableColumn<Task, Integer> idColumn;

    @FXML
    private TextField taskDescription;

    @FXML
    private TextField taskTitle;

    @FXML
    private ChoiceBox<Priority> setPriority;

    @FXML
    private Button addButton;

    @FXML
    private Button delButton;

    @FXML
    private TextField currentID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        taskDescription.setText("Enter description ...");
        taskTitle.setText("Enter title ...");
        setPriority.setItems(priorities);
        taskTable.setItems(tasks);

        setPriority.valueProperty().bindBidirectional(currentTask.priorityProperty());
        taskDescription.textProperty().bindBidirectional(currentTask.descriptionProperty());
        taskTitle.textProperty().bindBidirectional(currentTask.titleProperty());

        StringConverter convert = new NumberStringConverter();
        currentID.textProperty().bindBidirectional(currentTask.IDProperty(), convert);

        priorityColumn.setCellValueFactory(rowData -> rowData.getValue().priorityProperty());
        statusColumn.setCellValueFactory(rowData -> rowData.getValue().statusProperty());
        titleColumn.setCellValueFactory(rowData -> rowData.getValue().titleProperty());
        descriptionColumn.setCellValueFactory(rowData -> rowData.getValue().descriptionProperty());
        idColumn.setCellValueFactory(rowData -> rowData.getValue().IDProperty());



        tasks.addAll(
                new Task(1,"Pierwszy task", "Taki sobie pierwszy task"),
                new Task(2,"Drugi task", "Taki sobie drugi task"),
                new Task(3,"Trzeci task", "Taki sobie trzeci task", Priority.LOW));


        taskDescription.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
//                System.out.println("Zmieniona wartość DESCRIPTION to: " + ((ObservableValue)observable).getValue());
            }
        });

        taskTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Task>() {
            @Override
            public void changed(ObservableValue<? extends Task> observable, Task oldValue, Task newValue) {
                setCurrentTask(newValue);
            }
        });


        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Integer nextID = tasks.size() + 1;
                System.out.println(nextID); //TODO dlaczego nie moge tego wywalic???
                tasks.add(new Task (nextID, taskTitle.textProperty().getValue().toString(), taskDescription.textProperty().getValue().toString(), setPriority.getValue()));
            }
        });

        delButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int currentIndex = Integer.parseInt(currentID.textProperty().getValue());
                Task highlightedTask = tasks.get(currentIndex+1);
                tasks.remove(highlightedTask);
            }
        });
    }


    private void setCurrentTask(Task selectedTask) {
        if(selectedTask != null) {
            currentTask.setID(selectedTask.getID());
            currentTask.setPriority(selectedTask.getPriority());
            currentTask.setTitle(selectedTask.getTitle());
            currentTask.setDescription(selectedTask.getDescription());
        } else {
            currentTask.setID(null);
            currentTask.setPriority(Priority.MID);
            currentTask.setTitle(" ");
            currentTask.setDescription(" ");
        }
    }
}
