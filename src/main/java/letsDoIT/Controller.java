package letsDoIT;

import components.Priority;
import components.Status;
import components.Task;
import database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.scene.control.*;


public class Controller implements Initializable {

    private Task currentTask = Task.getObservableTask();

    private ObservableList<Task> tasks = FXCollections.observableArrayList();
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
    private Button updButton;



    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Database database = new Database();
        database.connect();

        tasks = database.showAllRecords();

        // Łączy observable listy z elementami graficznymi
        setPriority.setItems(priorities);
        taskTable.setItems(tasks);

        // Wyświetlanie tasków w tabeli
        idColumn.setCellValueFactory(rowData -> rowData.getValue().IDProperty());
        priorityColumn.setCellValueFactory(rowData -> rowData.getValue().priorityProperty());
        statusColumn.setCellValueFactory(rowData -> rowData.getValue().statusProperty());
        titleColumn.setCellValueFactory(rowData -> rowData.getValue().titleProperty());
        descriptionColumn.setCellValueFactory(rowData -> rowData.getValue().descriptionProperty());

        // Zczytuje wybrany z listy task i wyswietla w okienkach (bindowanie poszczegolnych pol + listener dla Taska)
        setPriority.valueProperty().bindBidirectional(currentTask.priorityProperty());
        taskDescription.textProperty().bindBidirectional(currentTask.descriptionProperty());
        taskTitle.textProperty().bindBidirectional(currentTask.titleProperty());

        taskTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> setCurrentTask(newValue));


//        Obsługa buttona Add - Dodaje nowy task
        addButton.setOnAction(event -> {
            Task highlightedTask = new Task (taskTitle.textProperty().getValue(), taskDescription.textProperty().getValue(), setPriority.getValue());
            tasks.add(highlightedTask);
            database.addRecord(highlightedTask);
        });


        // Obsługa buttona Update - Updatuje wybrany task TODO
        updButton.setOnAction(event -> {
            Task t;
            t = tasks.get(currentTask.getID());
            t.setTitle(currentTask.getTitle());
            t.setDescription(currentTask.getDescription());
            t.setPriority(currentTask.getPriority());
        });

//        Obsługa buttona Del - usuwa wybrany task
        delButton.setOnAction(event -> {
            Alert delAlert = new Alert(Alert.AlertType.CONFIRMATION);
            delAlert.setHeaderText(null);
            delAlert.setTitle("Delete Task");
            delAlert.setContentText("You are going to delete selected task. Are you sure?");
            delAlert.getButtonTypes().remove(0,2);
            delAlert.getButtonTypes().add(0, ButtonType.YES);
            delAlert.getButtonTypes().add(1,ButtonType.NO);
            Optional<ButtonType> cofirmation = delAlert.showAndWait();
            if(cofirmation.get() == ButtonType.YES) {
                int currentId = taskTable.getSelectionModel().selectedIndexProperty().get();
                int currentDBId = taskTable.getSelectionModel().getSelectedItem().getID();
                tasks.remove(currentId);
                database.delRecord(currentDBId);
                setCurrentTask(null);
            }
        });


        // Ustawia predefiniowany tekst w polach tekstowych
        taskDescription.setText("Enter description ...");
        taskTitle.setText("Enter title ...");

    }


//    @FXML
//    void addButtonClicked(ActionEvent event) {
//        tasks.add(new Task (taskTitle.textProperty().getValue(), taskDescription.textProperty().getValue(), setPriority.getValue()));
//    }

    @FXML
    void delButtonClicked(ActionEvent event) {
        Alert delAlert = new Alert(Alert.AlertType.CONFIRMATION);
        delAlert.setHeaderText(null);
        delAlert.setTitle("Delete Task");
        delAlert.setContentText("You are going to delete selected task. Are you sure?");
        delAlert.getButtonTypes().remove(0,2);
        delAlert.getButtonTypes().add(0, ButtonType.YES);
        delAlert.getButtonTypes().add(1,ButtonType.NO);
        Optional<ButtonType> cofirmation = delAlert.showAndWait();
        if(cofirmation.get() == ButtonType.YES) {
            tasks.remove(taskTable.getSelectionModel().selectedItemProperty().get());
            setCurrentTask(null);
        }
    }

    private void setCurrentTask(Task selectedTask) {
        if(selectedTask != null) {
            currentTask.setPriority(selectedTask.getPriority());
            currentTask.setTitle(selectedTask.getTitle());
            currentTask.setDescription(selectedTask.getDescription());
        } else {
            currentTask.setPriority(Priority.MID);
            currentTask.setTitle(" ");
            currentTask.setDescription(" ");
        }
    }
}


