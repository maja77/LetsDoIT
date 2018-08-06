package letsDoIT;

import components.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Gui extends Application {

    public static void main(String[] args) {

//        TaskBoardImpl backlog = new TaskBoardImpl();
//        User user1 = new UserImpl("maja@lysiak.com.pl", "Maja", "12345");
//        Task firstTask = new Task("Task", Priority.LOW, Status.TODO);
//
//        user1.addTask(firstTask, backlog);
//
//        backlog.showContent();

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = new File("src/main/java/letsDoIT/Gui.fxml").toURI().toURL();
        HBox box = FXMLLoader.load(url);

        primaryStage.setTitle("LetsDoIT");
        primaryStage.setScene(new Scene(box));
        primaryStage.show();

    }

}


// For later - connection with database

//    Database database = new Database();
////        database.connect();
////
////                Task task1 = new Task("Task", "Pierwszy task");
////
////                int ile = 20;
////                for(int i = 0;i < ile; i++){
////        System.out.println(("task: " + task1.getTitle() + " "+ task1.getDescription() + " has been added with id: ") + database.addRecord(task1)  );
////
////        }