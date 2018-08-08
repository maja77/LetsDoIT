package letsDoIT;

import database.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
        primaryStage.setAlwaysOnTop(false);
        primaryStage.setScene(new Scene(box));
//        primaryStage.getOnCloseRequest(event -> {
//            onClose(event);
//        });
        primaryStage.show();

        Database database = new Database();
        database.connect();

    }

//    private void onClose(WindowEvent event) {
//        new Alert(Alert.AlertType.INFORMATION, event.getEventType().getName());
//    }
}




