package letsDoIT;

import components.Priority;
import components.Status;
import components.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;


public class Controller implements Initializable {

    private final Task currentTask = Task.getObservableTask();

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
                new Task("Pierwszy task", "Taki sobie pierwszy task"),
                new Task("Drugi task", "Taki sobie drugi task"),
                new Task("Trzeci task", "Taki sobie trzeci task", Priority.LOW));


        taskDescription.textProperty().addListener(observable -> {
//                System.out.println("Zmieniona wartość DESCRIPTION to: " + ((ObservableValue)observable).getValue());
        });

        taskTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> setCurrentTask(newValue));


        addButton.setOnAction(event -> {
            tasks.add(new Task (taskTitle.textProperty().getValue().toString(), taskDescription.textProperty().getValue().toString(), setPriority.getValue()));
        });

        delButton.setOnAction(event -> {
            Task highlightedTask = taskTable.getSelectionModel().selectedItemProperty().get();
            tasks.remove(highlightedTask);
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
