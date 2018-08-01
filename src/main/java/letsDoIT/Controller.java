package letsDoIT;


import components.Priority;
import components.Status;
import components.Task1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class Controller implements Initializable {

    private final Task1 currentTask = new Task1();

    private final ObservableList<Task1> tasks = FXCollections.observableArrayList();

    @FXML
    private TableView<Task1> taskTable = new TableView<Task1>();

    @FXML
    private TableColumn<Task1, Priority> priorityColumn;

    @FXML
    private TableColumn<Task1, Status> statusColumn;

    @FXML
    private TableColumn<Task1, String> titleColumn;

    @FXML
    private TableColumn<Task1, String> descriptionColumn;

    @FXML
    private TextField taskDescription;

    @FXML
    private TextField taskTitle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        taskDescription.setText("Enter description ...");
        taskTitle.setText("Enter title ...");

        taskTable.setItems(tasks);

        titleColumn.setCellValueFactory(rowData -> rowData.getValue().titleProperty());
        descriptionColumn.setCellValueFactory(rowData -> rowData.getValue().descriptionProperty());

        tasks.addAll(
                new Task1(1,"Pierwszy task", "Taki sobie pierwszy task"),
                new Task1(2,"Drugi task", "Taki sobie inny task"),
                new Task1(3,"Trzeci task", "Taki sobie kolejny task"));
    }
}
