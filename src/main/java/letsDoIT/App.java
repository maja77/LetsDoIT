package letsDoIT;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class App extends Application {

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
        URL url = new File("src/main/java/letsDoIT/HomePage.fxml").toURI().toURL();
        HBox box = FXMLLoader.load(url);

        primaryStage.setTitle("LetsDoIT");
        primaryStage.setAlwaysOnTop(false);
        primaryStage.setScene(new Scene(box));
        primaryStage.show();




    }
}




